package hanu.edu.infrastructure.customer.entity;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.infrastructure.user.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "customer")
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CustomerEntity extends UserEntity {

    public static CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
                .id(customer.getId())
                .username(customer.getUsername())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .enabled(true)
                .role("ROLE_CUSTOMER")
                .name(customer.getName())
                .age(customer.getAge())
                .address(customer.getAddress())
                .avatar(customer.getAvatar())
                .phone(customer.getPhone())
                .build();
    }

    public Customer toCustomer() {
        return new Customer(getId(), getUsername(), getEmail(), getPassword(), isEnabled(), getRole(),
                getName(), getAge(), getAddress(), getAvatar(), getPhone());
    }
}