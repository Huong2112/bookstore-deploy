package hanu.edu.domain.customer.service;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void updateCustomer(long customerId, Customer customer) {

        customerRepository.updateByCustomerId(customerId, customer);
//        if (customerRepository.getIdCustomer(customer) == customerId) {
//            customer.setId(customerId);
//            OutputCustomer outputCustomer = OutputCustomer.builder()
//                            .username(customer.getUsername())
//                                    .email(customer.getEmail())
//                                            .password(customer.getPassword())
//                                                    .name(customer.getName())
//                                                            .address(customer.getAddress())
//                                                                    .avatar(customer.getAvatar())
//                                                                            .phone(customer.getPhone());
//            outputCustomer.add
//            customerRepository.save(customer);
//        };
    }
}

@Builder
@Getter
class OutputCustomer {
    private String username;

    private String email;

    private String password;

    private String name;

    private String address;

    private String avatar;

    private String phone;
}
