package timetableapp.dao;

import java.util.List;
import timetableapp.domain.User;

public interface UserDao {
    
    User create(User user) throws Exception;
    
    User findByUsername(String username);

    List<User> getAll();
    
}
