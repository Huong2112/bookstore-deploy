package hanu.edu.infrustructure.customer.repository.jpa;

import hanu.edu.domain.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJPARepository extends JpaRepository<Customer, Long> {
}
