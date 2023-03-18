package hanu.edu.domain.customer.service;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//CRUD methods
@Service
public class CustomerResourceService extends UserResourceService {

    @Autowired
    private CustomerRepository customerRepository;

    public void create(Customer customer) {
        customerRepository.save(CustomerEntity.toEntity(customer));
    }
}
