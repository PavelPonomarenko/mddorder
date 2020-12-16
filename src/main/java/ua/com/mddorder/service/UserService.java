package ua.com.mddorder.service;

import javassist.NotFoundException;
import org.springframework.stereotype.Service;
import ua.com.mddorder.domain.User;

import java.util.List;

@Service
public interface UserService {

    User save(User user);

    void delete(long id);

    User get(long id) throws NotFoundException;

//    User getByEmail(String email) throws NotFoundException;

    List<User> getAll();

    void update(User user) throws NotFoundException;


}
