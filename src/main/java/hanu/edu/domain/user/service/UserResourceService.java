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
        return Optional.ofNullable(userRepository.findByUsername(username).get().toUser());
    }

    public void create(User user) {
        userRepository.save(UserEntity.toEntity(user));
    }
}
