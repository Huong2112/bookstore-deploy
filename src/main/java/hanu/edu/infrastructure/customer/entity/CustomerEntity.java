package hanu.edu.infrastructure.customer.entity;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.infrastructure.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity(name = "customer") 
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class CustomerEntity extends UserEntity {
    public CustomerEntity(String username, String password, String email) {
        super(username, password, email);
        setRole("ROLE_CUSTOMER");
    }

    public static CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .enabled(customer.isEnabled())
                .role(customer.getRole())
                .name(customer.getName())
                .age(customer.getAge())
                .address(customer.getAddress())
                .avatar(customer.getAvatar()).build();
    }
}