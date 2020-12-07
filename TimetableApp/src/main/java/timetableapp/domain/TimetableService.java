package timetableapp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import timetableapp.dao.TimetableDao;
import timetableapp.dao.UserDao;
import java.util.List;

public class TimetableService {
    
    private TimetableDao timetableDao;
    private UserDao userDao;
    private User loggedIn;
    private Timetable activeTable;
    private ArrayList<Event> activeEvents;
    private List<Timetable> userTimetables;
    
    public TimetableService(UserDao userDao, TimetableDao timetableDao) {
        this.userDao = userDao;
        this.timetableDao = timetableDao;
        this.loggedIn = null;
        this.activeTable = null;
        this.activeEvents = null;
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
        this.setActivetable(1);
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
    
    public void setActivetable(int week) {
        Timetable newActive = userTimetables.stream()
                .filter(t->t.getWeek() == week)
                .findFirst()
                .orElse(null);
        
        this.activeTable = newActive;
        this.activeEvents = this.activeTable.getEvents();
    }
    
    public int getActivetableWeek() {
        if(activeTable == null) {
            return 0;
        }
        return activeTable.getWeek();     
    }
    
    public boolean createEvent(String subject, int start, int stop, String day) {
        Event event = new Event(subject, start, stop, day);
        try {
            timetableDao.createEvent(event, activeTable);
        } catch (Exception e) {
            return false;
        }
        return true;    
    }
    
    public ArrayList<String> eventsToString() {
        ArrayList events = new ArrayList<>();
        try {
            for (Event event : this.activeEvents) {
                events.add(event.toString());
            }
        } catch (Exception e) {
            return null;
        }   
        return events;
    }
}
