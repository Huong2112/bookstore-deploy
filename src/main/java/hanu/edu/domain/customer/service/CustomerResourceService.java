package hanu.edu.domain.customer.service;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

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
        customer.setPassword(encoder.encode(customer.getPassword()));
        customerRepository.save(CustomerEntity.toEntity(customer).toCustomer());
    }

    public Customer getById(long customerId) {
        int passwordLength = customerRepository.getById(customerId).getPassword().length();
        String password = customerRepository.getById(customerId).getPassword();
        char[] chars = password.toCharArray();
        for (char decoderPass: chars) {
            decoderPass -= passwordLength;
            customerRepository.getById(customerId).setPassword(String.valueOf(decoderPass));
        }
        return customerRepository.getById(customerId);
    }



//    public void deleteById(long customerId) {
//        customerRepository.deleteById(customerId);
//    }

}
