package hanu.edu.domain.user.service;

import hanu.edu.domain.user.model.User;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.infrastructure.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//CRUD methods
@Service
public class UserResourceService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getByUsername(String username) {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        return user.map(UserEntity::toUser);
    }

    public Optional<User> getUserById(long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(UserEntity::toUser);
    }

    public void create(User user) {
        userRepository.save(UserEntity.toEntity(user));
    }
}
