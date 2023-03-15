package hanu.edu.domain.customer.repository;

import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import hanu.edu.infrastructure.user.entity.UserEntity;

public interface CustomerRepository {
    public void save(CustomerEntity customerEntity);
}
