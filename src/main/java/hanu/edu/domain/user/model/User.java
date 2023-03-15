package hanu.edu.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private boolean enabled;
    private String role;

    private String name;
    private int age;
    private String address;
    private String avatar;
    private String phone;
}