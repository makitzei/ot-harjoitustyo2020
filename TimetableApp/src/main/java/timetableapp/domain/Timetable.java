package timetableapp.domain;

import timetableapp.domain.Event;
import java.util.ArrayList;

public class Timetable {
    private int week;
    private ArrayList<Event> events;
    
    public Timetable(int week) {
        this.week = week;
        this.events = new ArrayList<>();
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
    
    @Override
    public String toString() {
        return "Timetable week " + this.week + " has " 
                + this.events.size() + " events";
    }

}
