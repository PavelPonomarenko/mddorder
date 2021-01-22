package ua.com.mddorder.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/api/v1/**").authenticated()
                .antMatchers("/api/v1/admin/**").hasAnyRole("ROLE_ADMIN", "ROLE_SUPERADMIN")
                .antMatchers("**/profile/**").authenticated()
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/");

    }
}
