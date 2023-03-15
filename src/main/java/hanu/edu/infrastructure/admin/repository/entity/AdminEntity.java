package hanu.edu.infrastructure.admin.repository.entity;

import hanu.edu.infrastructure.user.entity.UserEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "admin")
@Table(name = "admin")
@NoArgsConstructor
@Getter
@Setter
public class AdminEntity extends UserEntity {
    public AdminEntity(String username, String password, String email) {
        super(username, password, email);
        setRole("ROLE_ADMIN");
    }
}
