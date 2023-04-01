package hanu.edu.infrastructure.admin.entity;

import hanu.edu.domain.admin.model.Admin;
import hanu.edu.infrastructure.user.entity.UserEntity;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "admin")
@NoArgsConstructor
@SuperBuilder
public class AdminEntity extends UserEntity {
    public AdminEntity(String username, String password, String email) {
        super(username, password, email);
        setRole("ROLE_ADMIN");
        setEnabled(true);
    }

    public static AdminEntity toEntity(Admin admin) {
        return AdminEntity.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .enabled(true)
                .role("ROLE_ADMIN")
                .name(admin.getName())
                .age(admin.getAge())
                .address(admin.getAddress())
                .avatar(admin.getAvatar()).build();
    }
}
