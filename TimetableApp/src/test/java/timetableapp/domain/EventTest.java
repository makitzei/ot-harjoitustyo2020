package timetableapp.domain;

import timetableapp.domain.Event;
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
    public void setSubjecttRight() {
        event.setSubject("procrastination");
        assertEquals("procrastination", event.getSubject());
    }
    
    @Test
    public void setStartRight() {
        event.setStart(10);
        assertEquals(10, event.getStart());
    }
    
    @Test
    public void setStoptRight() {
        event.setStop(13);
        assertEquals(13, event.getStop());
    }
    
    @Test
    public void setDayRight() {
        event.setDay("tuesday");
        assertEquals("tuesday", event.getDay());
    }
    
    @Test
    public void toStringRight() {
        assertEquals("programming;monday;8;12", 
                event.toString());
    }
    

}
