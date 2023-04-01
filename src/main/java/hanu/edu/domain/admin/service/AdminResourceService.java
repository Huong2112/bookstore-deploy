package hanu.edu.domain.admin.service;

import hanu.edu.domain.admin.model.Admin;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.infrastructure.admin.entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//CRUD methods
@Service
public class AdminResourceService extends UserResourceService {

    @Autowired
    private UserRepository userRepository;

    public void create(Admin admin) {
        userRepository.save(AdminEntity.toEntity(admin));
    }
}
