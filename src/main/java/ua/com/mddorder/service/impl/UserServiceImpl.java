package ua.com.mddorder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.mddorder.dto.UserDto;
import ua.com.mddorder.model.User;
import ua.com.mddorder.repository.UserRepository;
import ua.com.mddorder.service.UserService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(Long id, String username, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("user with id " + id + " does not exists"));
        if (username != null && username.length() > 0
                && !Objects.equals(user.getUsername(), username)) {
            user.setUsername(username);
        }
        if (email != null && email.length() > 0 &&
                !Objects.equals(user.getEmail(), email)) {
            Optional<User> userOptional = userRepository.findUserByEmail(email);

            if (userOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userList) {
            userDtoList.add(UserDto.fromUserToUserDto(user));
        }
        return userDtoList;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        boolean exists = userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("user with id " + id + " does not exists");
        }
        userRepository.deleteUserById(id);
    }
}
