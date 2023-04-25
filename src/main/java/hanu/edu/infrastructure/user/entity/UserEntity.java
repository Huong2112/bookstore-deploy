package hanu.edu.infrastructure.user.entity;

import hanu.edu.domain.user.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;

@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NaturalId(mutable = true)
    private String username;
    @NaturalId(mutable = true)
    private String email;
    private String password;
    @Setter
    private boolean enabled;
    @Setter
    private String role;
    private String name;
    private int age;
    private String address;
    private String avatar;
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
                .role(user.getRole())
                .name(user.getName())
                .age(user.getAge())
                .address(user.getAddress())
                .avatar(user.getAvatar()).build();
    }

    public User toUser() {
        return new User(id, username, email, password, enabled, role, name, age, address, avatar, phone);
    }
}
