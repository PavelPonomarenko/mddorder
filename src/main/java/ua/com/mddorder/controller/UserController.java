package ua.com.mddorder.controller;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.com.mddorder.domain.User;
import ua.com.mddorder.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(UserController.REST_URL)
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    public static final String REST_URL = "/rest/user";

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@PathVariable("login") String login, @PathVariable("password") String password) {
        List<User> users = userService.getAll();

        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login) || user.getPassword().equalsIgnoreCase(password)) {
                return "redirect:/users";
            }
        }
//        boolean b = users.stream()
////                .filter(user -> user.getLogin().equalsIgnoreCase(login))
////                .anyMatch(user -> user.getLogin().equalsIgnoreCase(login));
//        Optional<User> optional;
//
////                .filter(user -> user.getPassword().equalsIgnoreCase(password))


        return "redirect:/error";

    }

    @GetMapping("/findAll")
    public String findAll(Model model) {
        LOGGER.info(UserController.class + " in findAll method");
        List<User> users = userService.getAll();
        LOGGER.info("list users in findAll method ->", users);
        users.forEach(System.out::println);
        model.addAttribute("users", users);
        return "userlist";

    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

//    @GetMapping("/user-update/{id}")
//    public String updateUserForm(@PathVariable("id") Long id, Model model) {
//        User user = userService.findById(id);
//        model.addAttribute("user", user);
//        return "user-update";
//    }

    @PostMapping("/user-update")
    public String updateUser(User user) throws NotFoundException {
        userService.update(user);
        return "redirect:/users";
    }

}
