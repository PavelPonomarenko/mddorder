package ua.com.mddorder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import ua.com.mddorder.domain.Role;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/authenticated/**", "/**").authenticated()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .antMatchers("/profile/**").authenticated()
                .and()
                .formLogin()
//                .loginProcessingUrl("/login2")
                .and()
                .logout().logoutSuccessUrl("/");
    }

    @Bean
//    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password("111")
                .roles(String.valueOf(Role.USER))
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("222")
                .roles(String.valueOf(Role.ADMIN))
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}