package hanu.edu.infrastructure.product.repository.jpa;

import hanu.edu.infrastructure.product.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductEntity, Long> {
}
