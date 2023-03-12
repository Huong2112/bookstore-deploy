package hanu.edu.domain.user.model;

import hanu.edu.domain.role.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@AllArgsConstructor
@Getter
public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private boolean enabled;
    private Set<Role> roles;

    private String name;
    private int age;
    private String address;
    private String avatar;
    private String phone;
}