package hanu.edu.infrastructure.role.repository.entity;

import hanu.edu.infrastructure.user.repository.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "role")
@Table(name = "role")
@NoArgsConstructor
@Getter
@Setter
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();

    public RoleEntity(String name) {
        this.name = name;
    }
}
