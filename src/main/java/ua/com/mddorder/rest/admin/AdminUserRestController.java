package ua.com.mddorder.rest.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.com.mddorder.dto.UserDto;
import ua.com.mddorder.model.User;
import ua.com.mddorder.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/admin/super/")
public class AdminUserRestController {

    private final UserService userService;

    @Autowired
    public AdminUserRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("users/all")
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> userDtoList = userService.getAll();
        if (userDtoList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        UserDto result = UserDto.fromUserToUserDto(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(path = "users/delete/{id}")
    public void delete(@PathVariable("id") Long userId) {
        userService.delete(userId);
    }

    @PostMapping(path = "users/add")
    public void registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    @PutMapping(path = "users/update/{id}")
    public void update(@PathVariable Long id,
                       @RequestParam(required = false) String username,
                       @RequestParam(required = false) String email) {
        userService.update(id, username, email);
    }
}
