package hanu.edu.infrastructure.security_service;

import hanu.edu.infrastructure.role.repository.entity.RoleEntity;
import hanu.edu.infrastructure.role.repository.jpa.RoleJPARepository;
import hanu.edu.infrastructure.user.repository.entity.UserEntity;
import hanu.edu.infrastructure.user.repository.jpa.UserJPARepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WebSecurityService implements UserDetailsService, IWebSecurityService {
    @Autowired
    private UserJPARepository userRepository;

    @Autowired
    private RoleJPARepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public UserEntity createUser(String username, String password, String email, RoleEntity... roles) {
        UserEntity user = new UserEntity(username, encoder.encode(password), email);
        for (RoleEntity roleEntity : roles) {
            user.addRole(roleEntity);
        }
        return user;
    }

    @Override
    @Transactional
    public void generateUsersRoles() {
        RoleEntity roleAdmin = new RoleEntity("ROLE_ADMIN");
        RoleEntity roleUser = new RoleEntity("ROLE_CUSTOMER");
        if (roleRepository.count() == 0) {
            roleRepository.save(roleAdmin);
            roleRepository.save(roleUser);
            roleRepository.flush();
        }

//        if (userRepository.findByUsername("admin").isEmpty()) {
//            UserEntity admin = createUser("admin", "999999", "admin@gmail.com", roleAdmin, roleUser);
//            userRepository.save(admin);
//            userRepository.flush();
//        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user!");
        }
        return user.get();
    }

}