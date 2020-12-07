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
                file.write("testEst2;" + String.valueOf(i) + ";\n");
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
    
    @After
    public void tearDown() {
        timetableFile.delete();
    }

}
