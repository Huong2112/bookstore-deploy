package hanu.edu.domain.customer.service;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//CRUD methods
@Service
public class CustomerResourceService extends UserResourceService {

    @Autowired
    private UserRepository userRepository;

    public void create(Customer customer) {
        userRepository.save(CustomerEntity.toEntity(customer));
    }
}
