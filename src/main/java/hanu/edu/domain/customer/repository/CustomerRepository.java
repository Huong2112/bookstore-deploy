package hanu.edu.domain.customer.repository;

import hanu.edu.infrastructure.customer.entity.CustomerEntity;

public interface CustomerRepository {
    public void save(CustomerEntity customerEntity);
}
