package hanu.edu.domain.product.repository;

import hanu.edu.domain.product.model.Product;
import hanu.edu.infrastructure.product.repository.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface ProductRepository {
    Page<Product> get(int page, int totalPage);

    Product getById(long id);

    void save(ProductEntity productEntity);

    void deleteById(long id);
}
