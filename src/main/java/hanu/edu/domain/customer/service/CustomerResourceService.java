package hanu.edu.domain.customer.service;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.domain.user.model.User;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import hanu.edu.infrastructure.user.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//CRUD methods
@Service
public class CustomerResourceService extends UserResourceService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    BCryptPasswordEncoder encoder;

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
