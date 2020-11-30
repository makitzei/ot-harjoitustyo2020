package timetableapp.dao;

import java.util.List;
import timetableapp.domain.Event;
import timetableapp.domain.Timetable;

public interface TimetableDao {
    
    Timetable create(Timetable timetable) throws Exception;

    List<Timetable> getAll();
    
    //Event createEvent(Event event) throws Exception;
    
    //List<Event> getAllEvents();
    
}
