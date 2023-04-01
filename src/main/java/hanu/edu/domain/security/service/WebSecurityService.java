package hanu.edu.domain.security.service;

import hanu.edu.domain.admin.repository.AdminRepository;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.infrastructure.admin.entity.AdminEntity;
import hanu.edu.infrastructure.user.entity.UserEntity;
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
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public void generateUsersRoles() {
        if (adminRepository.findByUsername("root").isEmpty()) {
            AdminEntity adminEntity = new AdminEntity("root", encoder.encode("root"), "root@gmail.com");
            adminRepository.save(adminEntity);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user!");
        }
        return user.get().toUser();
    }

}