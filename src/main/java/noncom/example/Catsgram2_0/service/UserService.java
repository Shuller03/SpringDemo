package noncom.example.Catsgram2_0.service;

import noncom.example.Catsgram2_0.dao.interfaces.UserDao;
import noncom.example.Catsgram2_0.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao){
        this.userDao=userDao;
    }

    public Optional<User> findUserById(String id){
        return userDao.findUserById(id);
    }
}
