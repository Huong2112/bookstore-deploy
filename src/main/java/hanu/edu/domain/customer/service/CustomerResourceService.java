package hanu.edu.domain.customer.service;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//CRUD methods
@Service
public class CustomerResourceService extends UserResourceService {

    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public void create(Customer customer) {
        userRepository.save(CustomerEntity.toEntity(customer));
    }

    public void update(Customer customer) {

        boolean status = false;
        while (!status) {
            customer.setPassword(encoder.encode(customer.getPassword()));
            customerRepository.save(CustomerEntity.toEntity(customer));
            break;
        }
    }

//    public void deleteById(long customerId) {
//        customerRepository.deleteById(customerId);
//    }
}
