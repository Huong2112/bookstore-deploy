package hanu.edu.infrustructure.customer.repository.jpa;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.infrustructure.customer.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJPARepository extends JpaRepository<CustomerEntity, Long> {
}
