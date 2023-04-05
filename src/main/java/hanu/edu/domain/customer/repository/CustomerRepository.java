package hanu.edu.domain.customer.repository;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.user.model.User;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;

public interface CustomerRepository {
    void save(Customer customer);

    Customer getByEmail(String email);

    void deleteById(long id);

    void save(CustomerEntity customerEntity);

    CustomerEntity getByCustomerId(long customerId);
}



/*
public void update(long customerId, Customer customer) {
        customer.setPassword(encoder.encode(customer.getPassword()));
        boolean status = false;
        User user = customerRepository.getByCustomerId(customerId).toCustomer();
        List<CustomerEntity> customers = user.getCustomerEntities();
        for (CustomerEntity c : customers) {
            if (c.getId() == customer.getId()) {
                customerRepository.save(c);
                status = true;
                break;
            }
        }
        if (!status) {
            customerRepository.save(CustomerEntity.toEntity(customer));
        }

    }
 */
