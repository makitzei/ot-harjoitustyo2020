package timetableapp.domain;

import timetableapp.domain.Timetable;
import timetableapp.domain.Event;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimetableTest {
    
    Timetable timetable;
    Event event1;
    Event event2;
    
    @Before
    public void setUp() {
        timetable = new Timetable("testaaja",42);
        event1 = new Event("programming", 8, 12, "monday");
        event2 = new Event("jogging", 15, 17, "tuesday");
    }
    
    @Test
    public void newTimetableExists() {
        assertTrue(timetable!= null);
    }
    
    @Test
    public void weekRightAfterConstruction() {
        assertEquals(42, timetable.getWeek());
    }
    
    @Test
    public void timeTableToStringRight() {
        assertEquals("Timetable week 42 has 0 events", timetable.toString());
    }
    
    @Test
    public void eventsEmptyAfterConstruction() {
        assertEquals(0, timetable.getEvents().size());
    }
    
    @Test
    public void eventsAddRight() {
        timetable.addEvent(event1);
        timetable.addEvent(event2);
        assertEquals(2, timetable.getEvents().size());
    }
    
    @Test
    public void timetableGetsFirstEventRight() {
        timetable.addEvent(event1);
        timetable.addEvent(event2);
        Event firstEvent = timetable.getEvents().get(0);
        assertEquals("Event: programming -- monday -- 8-12", 
                firstEvent.toString());
    }
    

}
