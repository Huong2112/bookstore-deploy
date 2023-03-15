package hanu.edu.infrastructure.customer.repository.entity;

import hanu.edu.infrastructure.user.repository.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customer")
@Table(name = "customer")
@NoArgsConstructor
@Getter
@Setter
public class CustomerEntity extends UserEntity {
    public CustomerEntity(String username, String password, String email) {
        super(username, password, email);
        setRole("ROLE_CUSTOMER");
    }
}