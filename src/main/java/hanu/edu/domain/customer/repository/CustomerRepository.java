package hanu.edu.domain.customer.repository;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;

public interface CustomerRepository {
    public void save(Customer customer);
    public Customer getByEmail(String email);
}
