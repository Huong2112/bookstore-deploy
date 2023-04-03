package hanu.edu.domain.customer.repository;

import hanu.edu.domain.customer.model.Customer;

public interface CustomerRepository {
    void save(Customer customer);

    Customer getByEmail(String email);

    Customer getByCustomerId(long customerId);

    void deleteByCustomerId(long customerId);
    void updateByCustomerId(long customerId, Customer customer);
}
