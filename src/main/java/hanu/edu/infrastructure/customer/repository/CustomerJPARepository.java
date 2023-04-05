package hanu.edu.infrastructure.customer.repository;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import hanu.edu.infrastructure.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerJPARepository extends JpaRepository<CustomerEntity, Long> {
    CustomerEntity findByEmail(String email);

    CustomerEntity getById(long id);

}
