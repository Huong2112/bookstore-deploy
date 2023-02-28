package hanu.edu.infrustructure.product.repository.jpa;

import hanu.edu.domain.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<Product, Long> {
}
