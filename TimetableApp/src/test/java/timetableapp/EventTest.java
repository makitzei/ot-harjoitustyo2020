package timetableapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EventTest {
    
    Event event;
    
    @Before
    public void setUp() {
       event = new Event("programming", 8, 12, "monday");
    }
    
    @Test
    public void newEventExists() {
        assertTrue(event != null);
    }
    
    @Test
    public void subjectRight() {
        assertEquals("programming", event.getSubject());
    }
    
    @Test
    public void startTimeRight() {
        assertEquals(8, event.getStart());
    }
    
    @Test
    public void stopTimeRight() {
        assertEquals(12, event.getStop());
    }
    
    @Test
    public void dayRight() {
        assertEquals("monday", event.getDay());
    }
    
    @Test
    public void toStringRight() {
        assertEquals("Event: programming -- monday -- 8-12", 
                event.toString());
    }
    
    @Test
    public void startLaterButBeforeStopSnoozesStart() {
        event.startLater(2);
        assertEquals(10, event.getStart());
    }
    
    @Test
    public void stopLaterButAfterStopWontChangeStart() {
        event.startLater(5);
        assertEquals(8, event.getStart());
    }
    
    @Test
    public void stopLaterButBeforeEndOfDayWorks() {
        event.stopLater(2);
        assertEquals(14, event.getStop());
    }
    
    @Test
    public void stopLaterButAfterEndOfDayWontChangeStop() {
        event.stopLater(10);
        assertEquals(12, event.getStop());
    }
    
    

}
