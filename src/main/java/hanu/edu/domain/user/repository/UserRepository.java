package hanu.edu.domain.user.repository;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.infrastructure.user.entity.UserEntity;

import java.util.Optional;

public interface UserRepository {
    void save(UserEntity userEntity);

    Optional<UserEntity> findByUsername(String username);


}
