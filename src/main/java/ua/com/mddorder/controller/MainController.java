package ua.com.mddorder.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.mddorder.model.RoleType;

import java.util.function.Predicate;

@Controller
public class MainController {

    @GetMapping("/")
    public String getPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities()
                .stream()
                .anyMatch((Predicate<GrantedAuthority>) grantedAuthority
                        -> grantedAuthority.getAuthority()
                        .equals(RoleType.ROLE_SUPERADMIN.name()))) {
            return "profile-super-admin";
        } else if (authentication.getAuthorities()
                .stream()
                .anyMatch((Predicate<GrantedAuthority>) grantedAuthority
                        -> grantedAuthority.getAuthority()
                        .equals(RoleType.ROLE_ADMIN.name()))) {
            return "profile-admin";


        } else if (authentication.getAuthorities()
                .stream()
                .anyMatch((Predicate<GrantedAuthority>) grantedAuthority
                        -> grantedAuthority.getAuthority()
                        .equals(RoleType.ROLE_EMPLOYEE.name()))) {
            return "profile-employee";
        }
        return "login";
    }
}



