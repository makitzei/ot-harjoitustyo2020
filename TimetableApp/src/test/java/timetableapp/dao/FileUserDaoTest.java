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
import timetableapp.domain.FakeUserDao;
import timetableapp.domain.User;

public class FileUserDaoTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    File userFile;  
    UserDao dao;
    
    
    @Before
    public void setUp() throws Exception {
        userFile = testFolder.newFile("test_users.txt");
        UserDao userDao = new FakeUserDao();
        
        try (FileWriter file = new FileWriter(userFile.getAbsolutePath())) {
            file.write("Essi Esimerkki;testEst\n");
            file.write("Essi Esimerkki2;testEst2\n");
        }
        
        dao = new FileUserDao(userFile.getAbsolutePath());
    }
    
    @Test
    public void usersAreReadCorrectlyFromFile() {
        List<User> users = dao.getAll();
        assertEquals(2, users.size());
        User user = users.get(0);
        assertEquals("Essi Esimerkki", user.getRealName());
        assertEquals("testEst", user.getUsername());
    }
    
    @Test
    public void existingUserFound() {
        User user = dao.findByUsername("testEst");
        assertEquals("Essi Esimerkki", user.getRealName());
        assertEquals("testEst", user.getUsername());
    }
    
    @Test
    public void nonExistingUserNotFound() {
        User user = dao.findByUsername("nonEst");
        assertEquals(null, user);
    }
    
    @Test
    public void savedUserIsFound() throws Exception {
        User user2 = new User("Erkki Esimerkki", "erkkinen");
        dao.create(user2);
        
        User user = dao.findByUsername("erkkinen");
        assertEquals("Erkki Esimerkki", user.getRealName());
        assertEquals("erkkinen", user.getUsername());
    }
    
    @After
    public void tearDown() {
        userFile.delete();
    }

}
