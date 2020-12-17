package ua.com.mddorder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public String root() {
        return "/rest/user/login";
    }

    @GetMapping("/authenticated")
    public String pageForAuthenticatedUser(Principal principal) {
        return "authenticated user " + principal.getName();
    }
}
