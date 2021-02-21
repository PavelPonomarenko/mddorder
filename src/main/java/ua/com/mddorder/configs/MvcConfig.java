package ua.com.mddorder.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("logout");
        registry.addViewController("/userList").setViewName("userList");
        registry.addViewController("/profile-employee").setViewName("profile-employee");
        registry.addViewController("/profile-admin").setViewName("profile-admin");
        registry.addViewController("/profile-super-admin").setViewName("profile-super-admin");
        registry.addViewController("/brand-name").setViewName("brand-name");
        registry.addViewController("/brand-name-form").setViewName("brand-name-form");
    }

}