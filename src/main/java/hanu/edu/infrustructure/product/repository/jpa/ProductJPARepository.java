package hanu.edu.infrustructure.product.repository.jpa;

import hanu.edu.domain.product.model.Product;
import hanu.edu.infrustructure.product.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductEntity, Long> {
}
