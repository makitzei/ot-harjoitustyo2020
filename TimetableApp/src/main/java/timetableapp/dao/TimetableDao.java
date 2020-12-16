package timetableapp.dao;

import java.util.List;
import timetableapp.domain.Event;
import timetableapp.domain.Timetable;

/**
 * Rajapinta Service-luokan ja tietokantatoteutuksen välille lukujärjestysten
 * tallentamiseen
 */

public interface TimetableDao {
    
    Timetable create(Timetable timetable) throws Exception;

    List<Timetable> getAll();
    
    Timetable findByWeek(int week);
    
    List<Timetable> findByUsername(String username);
    
    Event createEvent(Event event, Timetable timetable) throws Exception;
    
    Event deleteEvent(int index, Timetable timetable) throws Exception;
       
}
