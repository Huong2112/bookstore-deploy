package hanu.edu.infrastructure.user.repository;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.user.model.User;
import hanu.edu.infrastructure.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String admin);

    UserEntity findById(long id);
}
