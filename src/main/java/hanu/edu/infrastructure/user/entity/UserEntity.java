package hanu.edu.infrastructure.user.entity;

import hanu.edu.domain.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;

@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NaturalId
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NaturalId
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean enabled = true;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "phone")
    private String phone;

    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .enabled(user.isEnabled())
                .role("ROLE_USER")
                .name(user.getName())
                .age(user.getAge())
                .address(user.getAddress())
                .avatar(user.getAvatar()).build();
    }

    public User toUser() {
        return new User(id, username, email, password, enabled, role, name, age, address, avatar, phone);
    }
}
