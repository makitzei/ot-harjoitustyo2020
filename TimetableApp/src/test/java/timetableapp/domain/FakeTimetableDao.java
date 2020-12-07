package timetableapp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import timetableapp.dao.TimetableDao;

public class FakeTimetableDao implements TimetableDao {
    List<Timetable> timetables = new ArrayList<>();
    
    public FakeTimetableDao() {
        for (int i = 1; i <= 52; i++) {
            timetables.add(new Timetable("testEst", i));
        }
        for (int i = 1; i <= 52; i++) {
            timetables.add(new Timetable("testEst2", i));
        }
            
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
    
}
