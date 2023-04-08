package hanu.edu.infrastructure.customer.repository;

import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJPARepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);

    CustomerEntity getById(long id);

}
