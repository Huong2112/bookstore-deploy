package hanu.edu.infrastructure.user.repository;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.infrastructure.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserJPARepository userJPARepository;

    public void save(UserEntity userEntity) {
        userJPARepository.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findByUsername(String username) {
        return userJPARepository.findByUsername(username);
    }


}
