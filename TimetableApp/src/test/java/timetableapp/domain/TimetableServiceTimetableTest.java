package timetableapp.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimetableServiceTimetableTest {
    
    FakeUserDao userDao;
    FakeTimetableDao timetableDao;
    TimetableService service;
    
    @Before
    public void setUp() {
        userDao = new FakeUserDao();
        timetableDao = new FakeTimetableDao();
        service = new TimetableService(userDao, timetableDao);    
    }
    
    @Test
    public void timetablesRightAfterLogin() {
        service.login("testEst");
        Timetable t = service.getActivetable();
        assertEquals(1, service.getActivetableWeek());
    }

    @Test
    public void activeTimetableCanChange() {
        service.login("testEst");
        service.setActivetable(5);
        Timetable t = service.getActivetable();
        assertEquals(5, t.getWeek());
    }
    
    @Test
    public void createEventSuccess() {
        service.login("testEst");
        service.setActivetable(5);
        boolean result = service.createEvent("opiskelu", 8, 14, "maanantai");
        assertTrue(result);
    }
    
    @Test
    public void deleteEventSuccess() {
        service.login("testEst");
        service.setActivetable(5);
        service.createEvent("opiskelu", 8, 14, "maanantai");
        service.createEvent("vapaa", 10, 14, "perjantai");
        service.createEvent("liikunta", 15, 16, "perjantai");
        boolean result = service.deleteEvent("perjantai", 15);
        assertTrue(result);
    }
    
    @Test
    public void eventConflictFound() {
        service.login("testEst");
        service.setActivetable(5);
        service.createEvent("opiskelu", 8, 14, "maanantai");
        service.createEvent("vapaa", 10, 14, "perjantai");
        boolean result = service.checkEventConflicts(11, 12, "perjantai");
        assertTrue(result);
    }
    
    @Test
    public void noEventConflictFound() {
        service.login("testEst");
        service.setActivetable(5);
        service.createEvent("opiskelu", 8, 14, "maanantai");
        service.createEvent("vapaa", 10, 14, "perjantai");
        boolean result = service.checkEventConflicts(15, 16, "perjantai");
        assertFalse(result);
    }
    
    @Test
    public void correctAmountOfEventsToString() {
        service.login("testEst");
        service.setActivetable(5);
        service.createEvent("opiskelu", 8, 14, "maanantai");
        service.createEvent("vapaa", 10, 14, "perjantai");
        service.createEvent("liikunta", 15, 16, "perjantai");
        
    }
    
}
