package noncom.example.Catsgram2_0.dao.interfaces;

import noncom.example.Catsgram2_0.model.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findUserById(String id);
}
