package timetableapp.domain;

import timetableapp.domain.Timetable;
import java.util.ArrayList;

/**
 * Järjestelmän käyttäjää edustava luokka
 */

public class User {
    private String realName;
    private String username;
    private ArrayList<Timetable> timetables;
    
    public User(String realName, String username) {
        this.realName = realName;
        this.username = username;
        this.timetables = new ArrayList<>();
    }
    
    public String getRealName() {
        return this.realName;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public ArrayList<Timetable> getTimetables() {
        return this.timetables;
    }
    
    public void addTimetable(Timetable timetable) {
        this.timetables.add(timetable);
    }
            
}
