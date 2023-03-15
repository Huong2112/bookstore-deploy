package hanu.edu.infrastructure.user.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "user")
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(unique = true, nullable = false)
    @Length(min = 4, max = 20, message = "Usename should contain about 4-20 characters.")
    private String username;

    @NaturalId
    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email.")
    private String email;

    @Column(nullable = false)
    @Length(min = 6, message = "Password should contains at least 6 characters.")
    private String password;

    @Column(name = "enable")
    private boolean enabled;

    @Transient
    @Column(name = "role")
    private String role = new String();

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    @Min(value = 10, message = "Age should not be less than 10.")
    @Max(value = 100, message = "Age should not be greater than 100.")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "phone")
    @Pattern(regexp = "[0-9]{10}", message = "Invalid phone number.")
    private String phone;

    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

        this.role = "ROLE_USER";
        this.enabled = true;
        this.age = 10;
        this.address = "";
        this.avatar = "";
        this.phone = "0000000000";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(this.role));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
