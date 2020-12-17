package timetableapp.domain;

import timetableapp.domain.Event;
import java.util.ArrayList;

/**
 * Lukujärjestyspohjaa edustava luokka
 */

public class Timetable {
    private String username;
    private int week;
    private ArrayList<Event> events;
    
    /**
     * Konstruktori
     * 
     * @param username  käyttäjän käyttäjänimi
     * @param week      lukujärjestyksen viikko
     */
    
    public Timetable(String username, int week) {
        this.username = username;
        this.week = week;
        this.events = new ArrayList<>();
    }
    
    public String getUser() {
        return this.username;
    }
    
    public int getWeek() {
        return this.week;
    }
    
    public ArrayList<Event> getEvents() {
        return this.events;
    }
    
    public void addEvent(Event event) {
        this.events.add(event);
    }
    
    public void deleteEvent(int index) {
        this.events.remove(index);
    }
    
    /**
     * Lukujärjestyksen tekstimuotoesitys testaamista varten
     * 
     * @return Lukujärjestyksen viikko ja tapahtumien määrä osana virkettä "Timetable week __ has __ events" 
     */
    
    @Override
    public String toString() {
        return "Timetable week " + this.week + " has " 
                + this.events.size() + " events";
    }

}
