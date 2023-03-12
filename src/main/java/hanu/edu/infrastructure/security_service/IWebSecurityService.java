package hanu.edu.infrastructure.security_service;

import jakarta.transaction.Transactional;

public interface IWebSecurityService {

    @Transactional
    void generateUsersRoles();
}