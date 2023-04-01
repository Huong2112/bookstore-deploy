package hanu.edu.infrastructure.product.repository;

import hanu.edu.infrastructure.product.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJPARepository extends JpaRepository<ProductEntity, Long> {
    Page<ProductEntity> findAllByNameContaining(String name, Pageable pageable);
}
