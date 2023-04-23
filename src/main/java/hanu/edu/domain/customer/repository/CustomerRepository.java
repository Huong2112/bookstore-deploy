package hanu.edu.domain.customer.repository;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;

public interface CustomerRepository {
    void save(Customer customer);

    Customer getByEmail(String email);

    void deleteById(long id);

    //void save(CustomerEntity customerEntity);

    Customer getById(long customerId);
}


