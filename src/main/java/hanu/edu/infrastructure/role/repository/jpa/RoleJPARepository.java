package hanu.edu.infrastructure.role.repository.jpa;

import hanu.edu.infrastructure.role.repository.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleJPARepository extends JpaRepository<RoleEntity, Long> {
}
