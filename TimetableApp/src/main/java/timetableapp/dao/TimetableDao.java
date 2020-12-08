package timetableapp.dao;


import java.util.List;
import timetableapp.domain.Event;
import timetableapp.domain.Timetable;

public interface TimetableDao {
    
    Timetable create(Timetable timetable) throws Exception;

    List<Timetable> getAll();
    
    Timetable findByWeek(int week);
    
    List<Timetable> findByUsername(String username);
    
    Event createEvent(Event event, Timetable timetable) throws Exception;
    
    
}
