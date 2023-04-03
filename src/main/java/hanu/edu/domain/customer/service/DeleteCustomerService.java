package hanu.edu.domain.customer.service;

import hanu.edu.domain.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void deleteCustomer(long customerId) {
        customerRepository.deleteByCustomerId(customerId);
    }

}
