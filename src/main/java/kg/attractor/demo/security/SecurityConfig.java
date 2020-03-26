package kg.attractor.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/likes/**", "/subscriptions/**", "/comments/**",
                        "/images/**", "/users/**", "/posts/*", "/posts/*/*")
                .fullyAuthenticated();

        http.authorizeRequests()
                .antMatchers("/posts/")
                .permitAll()
                .anyRequest()
                .permitAll();
// Configuring session storage. Don't store the session.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// Using Http Basic authorization.
// User data is passed through the request header
        // Since we log in via the request header,
// we don't need a form for entering and exiting the site either.
        /// Since we have a REST service, we don't need CSRF protection
        http.httpBasic();
        http.formLogin().disable().logout().disable();
        http.csrf().disable();
    }

}
