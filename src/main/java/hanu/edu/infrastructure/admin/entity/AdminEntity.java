package hanu.edu.infrastructure.admin.entity;

import hanu.edu.domain.admin.model.Admin;
import hanu.edu.domain.customer.model.Customer;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import hanu.edu.infrastructure.user.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

@Entity(name = "admin")
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class AdminEntity extends UserEntity {
    public AdminEntity(String username, String password, String email) {
        super(username, password, email);
        setRole("ROLE_ADMIN");
    }
}
