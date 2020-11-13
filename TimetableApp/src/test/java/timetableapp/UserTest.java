package timetableapp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    
    User user;
    
    @Before
    public void setUp() {
        user = new User("Bob John", "bobby");
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
   
}
