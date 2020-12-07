package timetableapp.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import timetableapp.domain.Event;
import timetableapp.domain.Timetable;

public class FileTimetableDao implements TimetableDao {
    
    private List<Timetable> timetables;
    //private List<Event> events;
    private String file;
    
    public FileTimetableDao(String file) throws Exception {
        timetables = new ArrayList<>();
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                Timetable t = new Timetable(parts[0], Integer.parseInt(parts[1]));
                for (int i = 2; i < parts.length; i = i+4) {
                    Event event = new Event(parts[i], Integer.parseInt(parts[i+2]), 
                            Integer.parseInt(parts[i+3]), parts[i+1]);
                    t.addEvent(event);
                }
                timetables.add(t);
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }
    
    private void save() throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            for (Timetable timetable : timetables) {
                String eventsString = "";
                for (Event event : timetable.getEvents()){
                    eventsString = eventsString + event.toString()+ ";";
                }
                writer.write(timetable.getUser() + ";" + timetable.getWeek() 
                        + ";" + eventsString +"\n");
            }
        }
    }    

    @Override
    public Timetable create(Timetable timetable) throws Exception {
        timetables.add(timetable);
        save();
        return timetable;
    }

    @Override
    public List<Timetable> getAll() {
        return timetables;
    }
    
    @Override
    public Timetable findByWeek(int week) {
        return timetables.stream()
            .filter(t->t.getWeek() == week)
            .findFirst()
            .orElse(null);
    }
    
    @Override
    public List<Timetable> findByUsername(String username) {
        List<Timetable> result = timetables.stream()
            .filter(t->t.getUser().equals(username))
            .collect(Collectors.toList());
        return result;
    }

    @Override
    public Event createEvent(Event event, Timetable timetable) throws Exception {
        timetable.addEvent(event);
        save();
        return event;
    }
    
}
