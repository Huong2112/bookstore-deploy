package hanu.edu.domain.security.service;

import hanu.edu.domain.security.dto.BaseResponseDTO;
import hanu.edu.domain.security.dto.UserDTO;
import jakarta.transaction.Transactional;

public interface SecurityService {

    BaseResponseDTO registerAccount(UserDTO userDTO);

    @Transactional
    void generateUsersRoles();
}