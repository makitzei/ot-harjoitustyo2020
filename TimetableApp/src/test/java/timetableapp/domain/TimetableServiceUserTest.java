package timetableapp.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimetableServiceUserTest {
    
    FakeUserDao userDao;
    FakeTimetableDao timetableDao;
    TimetableService service;
    
    @Before
    public void setUp() {
        userDao = new FakeUserDao();
        timetableDao = new FakeTimetableDao();
        service = new TimetableService(userDao,timetableDao);    
    }
    
    @Test
    public void existingUserCanLogIn() {
        boolean result = service.login("testEst");
        assertTrue(result);
        
        User loggedIn = service.getLoggedUser();
        assertEquals("Essi Esimerkki", loggedIn.getRealName());
    }    
    
    @Test
    public void nonExistingUserCantLogIn() {
        boolean result = service.login("nonEst");
        assertFalse(result);
        
        assertEquals(null, service.getLoggedUser());
    }   
    
    @Test
    public void loggedInUserCanLogout() {
        service.login("testEst");
        service.logout();
        
        assertEquals(null, service.getLoggedUser());
    }

    @Test
    public void userCreationFailsIfNameNotUnique() throws Exception {
        boolean result = service.createUser("Erkki Esimerkki","testEst");
        assertFalse(result);
    }
    
    @Test
    public void succesfullyCreatedUserCanLogIn() throws Exception {
        boolean result = service.createUser("Mosse Kissanen", "mosse");
        assertTrue(result);
        
        boolean loginOk = service.login("mosse");
        assertTrue(loginOk);
        
        User loggedIn = service.getLoggedUser();
        assertEquals("Mosse Kissanen", loggedIn.getRealName() );
    } 

}
