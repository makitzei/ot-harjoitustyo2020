package timetableapp.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import timetableapp.domain.FakeTimetableDao;
import timetableapp.domain.Timetable;
import timetableapp.domain.Event;

public class FileTimetableDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File timetableFile;  
    TimetableDao dao;

    @Before
    public void setUp() throws Exception {
        timetableFile = testFolder.newFile("test_timetables.txt");
        TimetableDao timetableDao = new FakeTimetableDao();
        
        try (FileWriter file = new FileWriter(timetableFile.getAbsolutePath())) {
            for (int i = 1; i <= 52; i++) {
                file.write("testEst;" + String.valueOf(i) + ";\n");
            }
            for (int i = 1; i <= 52; i++) {
                file.write("testEst2;" + String.valueOf(i) + ";opiskelu;tiistai;8;16;vapaa;perjantai;9;10" + ";\n");
            }
        }       
        dao = new FileTimetableDao(timetableFile.getAbsolutePath());
    }
    
    @Test
    public void tablesAreReadCorrectlyFromFile() {
        List<Timetable> timetables = dao.getAll();
        assertEquals(104, timetables.size());
        Timetable t = timetables.get(0);
        Timetable t2 = timetables.get(52);
        assertEquals("testEst", t.getUser());
        assertEquals(1, t.getWeek());
        assertEquals("testEst2", t2.getUser());
        assertEquals(1, t2.getWeek());
        assertEquals("opiskelu;tiistai;8;16", t2.getEvents().get(0).toString());
    }
    
    @Test
    public void tablesCanBeFoundByUsername() {
        String username = "testEst";
        List<Timetable> timetables = dao.findByUsername(username);
        assertEquals(52, timetables.size());
        Timetable t = timetables.get(0);
        Timetable t2 = timetables.get(51);
        assertEquals("testEst", t.getUser());
        assertEquals(1, t.getWeek());
        assertEquals("testEst", t2.getUser());
        assertEquals(52, t2.getWeek());
    }
    
    @Test
    public void savedEventFound() throws Exception {
        String username = "testEst";
        List<Timetable> timetables = dao.findByUsername(username);
        Timetable t = timetables.get(0);
        Event event1 = new Event("opiskelu", 8, 16, "tiistai");
        Event event2 = new Event("vapaa", 9, 10, "perjantai");
        dao.createEvent(event1, t);
        dao.createEvent(event2, t);
        assertEquals("opiskelu;tiistai;8;16", t.getEvents().get(0).toString());
    }
    
    @Test
    public void deletedEventNotFound() throws Exception {
        String username = "testEst";
        List<Timetable> timetables = dao.findByUsername(username);
        Timetable t = timetables.get(0);
        Event event1 = new Event("opiskelu", 8, 16, "tiistai");
        Event event2 = new Event("vapaa", 9, 10, "perjantai");
        dao.createEvent(event2, t);
        dao.createEvent(event1, t);
        dao.deleteEvent(0, t);
        assertEquals("opiskelu;tiistai;8;16", t.getEvents().get(0).toString());
    }
    
    
    
    @After
    public void tearDown() {
        timetableFile.delete();
    }

}
