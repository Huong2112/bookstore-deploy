package hanu.edu.application.customer.controller;

import hanu.edu.domain.security.dto.BaseResponseDTO;
import hanu.edu.domain.security.dto.UserDTO;
import hanu.edu.domain.security.service.SecurityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRegisterController {

    @Autowired
    private SecurityServiceImpl securityServiceImpl;

    @PostMapping(value = "/register")
    public ResponseEntity<BaseResponseDTO> register(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(securityServiceImpl.registerAccount(userDTO));
    }
}

