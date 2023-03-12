package hanu.edu.infrastructure.user.repository.entity;

import hanu.edu.infrastructure.role.repository.entity.RoleEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Getter
@Setter
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NaturalId
    @Column(unique = true, nullable = false)
    @Length(min = 5, max = 20, message = "Usename should contain about 6-20 characters.")
    private String username;

    @NaturalId
    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email.")
    private String email;

    @Column(nullable = false)
    @Length(min = 6, message = "Password should contains at least 6 characters.")
    private String password;

    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles = new HashSet<>();

    public UserEntity(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void addRole(RoleEntity roleEntity) {
        roles.add(roleEntity);
        roleEntity.getUsers().add(this);
    }

    public void removeRole(RoleEntity roleEntity) {
        roles.remove(roleEntity);
        roleEntity.getUsers().remove(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (RoleEntity roleEntity : roles) {
            authorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
        }
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
