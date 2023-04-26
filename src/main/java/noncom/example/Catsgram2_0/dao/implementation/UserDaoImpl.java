package noncom.example.Catsgram2_0.dao.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import noncom.example.Catsgram2_0.dao.interfaces.UserDao;
import noncom.example.Catsgram2_0.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final Logger log = LoggerFactory.getLogger(UserDaoImpl.class);

    public UserDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    @Override
    public Optional<User> findUserById(String id) {
//        SqlRowSet userRows = jdbcTemplate.queryForRowSet("select * from cat_user where id = '"+login+"'");
        SqlRowSet userRows = jdbcTemplate.queryForRowSet("select * from cat_user where id = ?", id);
        if (userRows.next()){
            User user = new User(
                userRows.getString("id"),
                userRows.getString("username"),
                userRows.getString("nickname"));

            log.info("User found: {} {}", user.getId(), user.getNickname());
            user.setId(id);

            return Optional.of(user);
        }
        else {
            log.info("User {} not found", id);
            return Optional.empty();
        }

    }
}
