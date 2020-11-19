package timetableapp;

import timetableapp.domain.User;
import timetableapp.domain.Timetable;
import timetableapp.domain.Event;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    
    User user;
    Timetable timetable1;
    Timetable timetable2;
    Event event1;
    Event event2;
    
    @Before
    public void setUp() {
        user = new User("Bob John", "bobby");
        timetable1 = new Timetable(42);
        timetable2 = new Timetable(43);
        event1 = new Event("programming", 8, 12, "monday");
        event2 = new Event("jogging", 15, 17, "tuesday");
        
    }
    
    @Test
    public void newUserExists() {
        assertTrue(user != null);
    }
    
    @Test
    public void getRealNameRight() {
        assertEquals("Bob John", user.getRealName());
    }
    
    @Test
    public void getUsernameRight() {
        assertEquals("bobby", user.getUsername());
    }
    
    @Test
    public void timetablesEmptyAfterConstruction() {
        assertEquals(0, user.getTimetables().size());
    }
    
    @Test
    public void timetablesAddRight() {
        user.addTimetable(timetable1);
        user.addTimetable(timetable2);
        assertEquals(2, user.getTimetables().size());
    }
    
    @Test
    public void userGetsFirstTimetableRight() {
        user.addTimetable(timetable1);
        user.addTimetable(timetable2);
        user.getTimetables().get(0).addEvent(event1);
        user.getTimetables().get(0).addEvent(event2);
        assertEquals("Timetable week 42 has 2 events", 
                user.getTimetables().get(0).toString());
    }
   
}
