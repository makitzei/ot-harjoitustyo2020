package timetableapp.domain;

import timetableapp.dao.TimetableDao;
import timetableapp.dao.UserDao;

public class TimetableService {
    
    private TimetableDao timetableDao;
    private UserDao userDao;
    private User loggedIn;
    
    public TimetableService(UserDao userDao, TimetableDao timetableDao) {
        this.userDao = userDao;
        this.timetableDao = timetableDao;
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
        
        loggedIn = user;
        
        return true;
    }
    
    public void logout() {
        loggedIn = null;
    }
    
    public User getLoggedUser() {
        return loggedIn;
    }
    
}
