package ua.com.mddorder.service;


import ua.com.mddorder.dto.UserDto;
import ua.com.mddorder.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);

    User addNewUser(User user);

    void update(Long id, String username, String email);
}