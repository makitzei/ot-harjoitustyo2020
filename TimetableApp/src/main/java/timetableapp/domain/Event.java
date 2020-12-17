package timetableapp.domain;

import java.util.ArrayList;

/**
 * Lukujärjestykseen lisättävää tapahtumaa edustava luokka
 */

public class Event {
    private String subject;
    private int start;
    private int stop;
    private String day;
    
    /**
     * Konstruktori
     * 
     * @param   subject     tapahtuman aihe
     * @param   start       alkamisaika tunteina
     * @param   stop        loppumisaika tunteina
     * @param   day         tapahtuman viikonpäivä
     * 
     */
    
    public Event(String subject, int start, int stop, String day) {
        this.subject = subject;
        this.start = start;
        this.stop = stop;
        this.day = day;
    }
    
    public String getSubject() {
        return this.subject;
    }
    
    public int getStart() {
        return this.start;
    }
    
    public int getStop() {
        return this.stop;
    }
    
    public String getDay() {
        return this.day;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    public void setStart(int start) {
        this.start = start;
    }
    
    public void setStop(int stop) {
        this.stop = stop;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    
    /**
     * Tapahtumaolion tekstimuotoesitys
     * 
     * @return tapahtuman aihe, päivä, alku ja loppu puolipisteellä erotettuina 
     */
    
    @Override
    public String toString() {
        return this.subject + ";" + this.day 
                + ";" + String.valueOf(start) 
                + ";" + String.valueOf(stop);
    }

}
