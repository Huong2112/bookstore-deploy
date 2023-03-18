package hanu.edu.infrastructure.admin.entity;

import hanu.edu.infrastructure.user.entity.UserEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
