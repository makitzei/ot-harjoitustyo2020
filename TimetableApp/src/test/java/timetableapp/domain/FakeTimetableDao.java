package timetableapp.domain;

import java.util.ArrayList;
import java.util.List;
import timetableapp.dao.TimetableDao;

public class FakeTimetableDao implements TimetableDao {
    List<Timetable> timetables = new ArrayList<>();
    
    public FakeTimetableDao() {
        timetables.add(new Timetable("testEst", 1));
    }
    
    @Override
    public List<Timetable> getAll() {
        return timetables;
    }

    @Override
    public Timetable create(Timetable timetable) throws Exception {
        timetables.add(timetable);
        return timetable;
    }
    
}
