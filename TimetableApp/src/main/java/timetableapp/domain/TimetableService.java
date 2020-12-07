package timetableapp.domain;

import timetableapp.dao.TimetableDao;
import timetableapp.dao.UserDao;
import java.util.List;

public class TimetableService {
    
    private TimetableDao timetableDao;
    private UserDao userDao;
    private User loggedIn;
    private Timetable activeTable;
    private List<Timetable> userTimetables;
    
    public TimetableService(UserDao userDao, TimetableDao timetableDao) {
        this.userDao = userDao;
        this.timetableDao = timetableDao;
        this.loggedIn = null;
        this.activeTable = null;
        this.userTimetables = null;
    }
    
    public boolean createUser(String name, String username)  {   
        if (userDao.findByUsername(username) != null) {
            return false;
        }
        User user = new User(name, username);
        try {
            userDao.create(user);
            for (int i = 1; i <= 52; i++) {
                Timetable timetable = new Timetable(username, i);
                timetableDao.create(timetable);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
     
    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }
        
        userTimetables = timetableDao.findByUsername(username);
        activeTable = userTimetables.get(0);
        loggedIn = user;
         
        return true;
    }
    
    public void logout() {
        loggedIn = null;
        activeTable = null;
        userTimetables = null;
    }
    
    public User getLoggedUser() {
        return loggedIn;
    }
    
    public Timetable getActivetable() {
        return activeTable;
    }
    
    public int getActivetableWeek() {
        if(activeTable == null) {
            return 0;
        }
        return activeTable.getWeek();
        
    }
    
}
