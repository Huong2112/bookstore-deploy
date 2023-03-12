package hanu.edu.infrastructure.security_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private IWebSecurityService webSecurityService;

    @Override
    public void run(String... args) throws Exception {
        webSecurityService.generateUsersRoles();
    }
}