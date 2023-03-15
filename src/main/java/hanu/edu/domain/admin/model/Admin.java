package hanu.edu.domain.admin.model;

import hanu.edu.domain.user.model.User;
import lombok.Getter;

@Getter
public class Admin extends User {

    public Admin(long id, String username, String email, String password, boolean enabled, String role, String name, int age, String address, String avatar, String phone) {
        super(id, username, email, password, enabled, role, name, age, address, avatar, phone);
    }
}
