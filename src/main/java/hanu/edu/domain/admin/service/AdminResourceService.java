package hanu.edu.domain.admin.service;

import hanu.edu.domain.admin.model.Admin;
import hanu.edu.domain.admin.repository.AdminRepository;
import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.infrastructure.admin.entity.AdminEntity;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import hanu.edu.infrastructure.user.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//CRUD methods
@Service
public class AdminResourceService extends UserResourceService {

    @Autowired
    private AdminRepository adminRepository;

    public void create(Admin admin) {
        adminRepository.save((AdminEntity) UserEntity.toEntity(admin));
    }
}
