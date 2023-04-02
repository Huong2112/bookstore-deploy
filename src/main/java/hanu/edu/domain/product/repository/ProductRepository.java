package hanu.edu.domain.product.repository;

import hanu.edu.domain.product.model.Product;
import hanu.edu.infrastructure.product.entity.ProductEntity;
import org.springframework.data.domain.Page;

public interface ProductRepository {
    Page<Product> getAllProductsByPage(int page, int size);

    Product getById(long id);

    void save(ProductEntity productEntity);

    void deleteById(long id);

    Page<Product> searchProductsByName(int page, int size, String name);

    Page<Product> sortProductsBy(int page, int size, String direction, String... properties);
}
