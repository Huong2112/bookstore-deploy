package hanu.edu.domain.customer.model;

import hanu.edu.domain.role.model.Role;
import hanu.edu.domain.user.model.User;
import lombok.Getter;

import java.util.Set;

@Getter
public class Customer extends User {

    public Customer(long id, String username, String email, String password, boolean enabled, Set<Role> roles, String name, int age, String address, String avatar, String phone) {
        super(id, username, email, password, enabled, roles, name, age, address, avatar, phone);
    }
}
