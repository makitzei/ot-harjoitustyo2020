package timetableapp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import timetableapp.dao.TimetableDao;
import timetableapp.dao.UserDao;
import java.util.List;

/**
 * Sovelluslogiikasta vastaava luokka
 */

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
    
    /**
    * Uuden käyttäjän luominen
    * 
    * @param    name   käyttäjän nimi
    * @param    username   käyttäjätunnus
    * 
    * @return   true jos käyttäjätunnus on luotu onnistuneesti, muuten false
    */
    
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
    
    /**
    * Kirjautuminen sisään järjestelmään
    * 
    * @param    username   käyttäjätunnus
    * 
    * @return   true jos käyttäjätunnus löytyy tietokannasta ja kirjautuminen onnistuu, muuten false
    */
     
    public boolean login(String username) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            return false;
        }
        
        userTimetables = timetableDao.findByUsername(username);
        //this.setActivetable(1);
        loggedIn = user;
         
        return true;
    }
    
    /**
    * Kirjautuminen ulos järjestelmästä
    * 
    */
    
    public void logout() {
        loggedIn = null;
        activeTable = null;
        userTimetables = null;
    }
    
    /**
    * Haetaan käyttäjä joka on kirjautuneena järjestelmään
    * 
    * @return   käyttäjä User-oliona
    */
    
    public User getLoggedUser() {
        return loggedIn;
    }
    
    /**
    * Haetaan lukujärjestys joka on tällä hetkellä tarkastelun alaisena tai käsittelyssä
    * 
    * @return   aktiivinen lukujärjestys Timetable-oliona
    */
    
    public Timetable getActivetable() {
        return activeTable;
    }
    
    /**
    * Vaihdetaan aktiivinen lukujärjestys
    * 
    * @param    week    viikon numero, jonka lukujärjestystä halutaan tarkastella
    */
    public void setActivetable(int week) {
        Timetable newActive = userTimetables.stream()
                .filter(t->t.getWeek() == week)
                .findFirst()
                .orElse(null);
        
        this.activeTable = newActive;
        this.activeEvents = this.activeTable.getEvents();
    }
    /**
    * Palauttaa aktiivisen lukujärjestyksen viikon
    * 
    * @return   viikon numero, jos on olemassa, 0 jos aktiivinen lukujärjestys ei ole määritelty
    */
    
    public int getActivetableWeek() {
        if(activeTable == null) {
            return 0;
        }
        return activeTable.getWeek();     
    }
    
    /**
    * Luodaan tapahtuma aktiivisena olevaan lukujärjestykseen
    * 
    * @param    subject     tapahtuman aihe
    * @param    start       tapahtuman aloitusaika
    * @param    stop        lopetusaika
    * @param    day         tapahtuman viikonpäivä
    * 
    * @return   true jos tapahtuman luominen onnistuu, false jos ei
    */
    
    public boolean createEvent(String subject, int start, int stop, String day) {
        Event event = new Event(subject, start, stop, day);
        try {
            timetableDao.createEvent(event, activeTable);
        } catch (Exception e) {
            return false;
        }
        return true;    
    }
    
    /**
    * Palauttaa aktiivisen lukujärjestyksen tapahtumat listana String-olioita
    * 
    * @return   tapahtumat listana, joka muodostuu tapahtumien toString-esityksistä
    */
    
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
