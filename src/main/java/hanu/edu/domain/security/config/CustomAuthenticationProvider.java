package hanu.edu.domain.security.config;

import hanu.edu.domain.security.exception.BaseException;
import hanu.edu.domain.user.model.User;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.infrastructure.user.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
// provide authentication
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("Start actual authentication.");

        // get user information
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();
        User user;
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

        // get authenticating user
        if (userEntity.isPresent()) {
            user = userEntity.get().toUser();
        } else {
            throw new BaseException(String.valueOf(HttpStatus.UNAUTHORIZED.value()), "User not found!");
        }

        // authorities --> authority, as project statement
        final List<GrantedAuthority> authority = List.of(new SimpleGrantedAuthority(user.getRole()));

        // provide authentication
        final Authentication auth = new UsernamePasswordAuthenticationToken(username, password, authority);

        log.info("End actual authentication.");
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication));
    }
}
