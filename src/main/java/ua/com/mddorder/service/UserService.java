package ua.com.mddorder.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import ua.com.mddorder.domain.User;

import java.util.List;

@Service
public interface UserService {

    User save(User user);

    void delete(long id);

    User getOne(long id) throws NotFoundException;

    List<User> getAll();

    void update(User user) throws NotFoundException;

    default User findByLogin(String username) {
        return null;
    }

    default User findByLoginAndPassword(String login, String password) {
        return null;
    }

    default void saveUser(User u) {

    }
}
