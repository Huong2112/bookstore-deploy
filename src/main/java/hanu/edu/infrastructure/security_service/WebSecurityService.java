package hanu.edu.infrastructure.security_service;

import hanu.edu.infrastructure.admin.repository.entity.AdminEntity;
import hanu.edu.infrastructure.admin.repository.AdminJPARepository;
import hanu.edu.infrastructure.customer.repository.CustomerJPARepository;
import hanu.edu.infrastructure.user.entity.UserEntity;
import hanu.edu.infrastructure.user.repository.UserJPARepository;
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
    private CustomerJPARepository customerJPARepository;

    @Autowired
    private AdminJPARepository adminJPARepository;

    @Autowired
    private  UserJPARepository userJPARepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    @Transactional
    public void generateUsersRoles() {
        if (adminJPARepository.findByUsername("root").isEmpty()) {
            AdminEntity adminEntity = new AdminEntity("root", encoder.encode("root"), "root@gmail.com");
            adminEntity.setName("root");
            adminJPARepository.saveAndFlush(adminEntity);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userJPARepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user!");
        }
        return user.get();
    }

}