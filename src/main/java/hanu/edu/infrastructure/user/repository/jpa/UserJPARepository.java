package hanu.edu.infrastructure.user.repository.jpa;

import hanu.edu.infrastructure.user.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String admin);
}
