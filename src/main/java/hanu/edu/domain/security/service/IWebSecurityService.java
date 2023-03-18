package hanu.edu.domain.security.service;

import jakarta.transaction.Transactional;

public interface IWebSecurityService {

    @Transactional
    void generateUsersRoles();
}