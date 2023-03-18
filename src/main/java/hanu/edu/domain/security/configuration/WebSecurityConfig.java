package hanu.edu.domain.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/admin", "/admin/**").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/register").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .cors().and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("username").passwordParameter("password")
                        .failureUrl("/login?error=true")
                        .loginProcessingUrl("/login")
                                .permitAll()
                )
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .permitAll()
                .and().rememberMe();
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}