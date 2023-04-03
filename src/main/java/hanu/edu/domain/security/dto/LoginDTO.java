package hanu.edu.domain.security.dto;

import lombok.Data;

@Data
// Request
public class LoginDTO {
    private String username;
    private String password;
}
