package ua.com.mddorder.service;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.mddorder.domain.User;
import ua.com.mddorder.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(long id) {
//        userRepository.delete(id);
    }

    @Override
    public User get(long id) throws NotFoundException {
        return userRepository.getOne(id);
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(User user) throws NotFoundException {
//        userRepository.update(user);
    }


}
