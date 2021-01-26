package ua.com.mddorder.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/auth/api/v1/admin")
    public String getAdminPage() {
        return "admin-page";
    }


}
