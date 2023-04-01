package hanu.edu.domain.customer.service;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.domain.shoppingCart.model.ShoppingCart;
import hanu.edu.domain.shoppingCart.repository.ShoppingCartRepository;
import hanu.edu.domain.user.service.UserResourceService;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//CRUD methods
@Service
public class CustomerResourceService extends UserResourceService {


    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public void create(Customer customer) {
        String encodedPassword = encoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        customerRepository.save(customer);
        Customer customerFromDB = customerRepository.getByEmail(customer.getEmail());
        shoppingCartRepository.save(new ShoppingCart(customerFromDB.getId(), null));
    }
}
