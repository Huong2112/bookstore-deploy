package hanu.edu.domain.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private SecurityService securityService;

    @Override
    public void run(String... args) {
        securityService.generateUsersRoles();
    }
}