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
    
    /**
     * Konstruktori, joka luo käyttäjälle myös tyhjän listan lukujärjestyksiä
     * 
     * @param realName  käyttäjän oikea nimi
     * @param username  käyttäjän käyttäjänimi
     */
    
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
    
    /**
     * Palauttaa kaikki käyttäjän lukujärjestykset
     * 
     * @return  käyttäjän lukujärjestykset listana Timetable-olioita 
     */
    public ArrayList<Timetable> getTimetables() {
        return this.timetables;
    }
    
    /**
     * Lisää lukujärjestyksen käyttäjälle
     * 
     * @param timetable lisättävä lukujärjestys
     */
    public void addTimetable(Timetable timetable) {
        this.timetables.add(timetable);
    }
            
}
