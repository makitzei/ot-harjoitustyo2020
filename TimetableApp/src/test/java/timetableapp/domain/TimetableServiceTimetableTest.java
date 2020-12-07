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
        service = new TimetableService(userDao,timetableDao);    
    }
    
    @Test
    public void timetablesRightAfterLogin() {
        service.login("testEst");
        Timetable t = service.getActivetable();
        assertEquals(1, t.getWeek());
    }    
    
    
}
