package hanu.edu.domain.product.service;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProductPagingAndSortingService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProductsByPage(int index, int size) {
        return productRepository.getAllProductsByPage(index, size);
    }

    public Page<Product> searchProductsByName(int index, int size, String name) {
        return productRepository.searchProductsByName(index, size, name);
    }

    public Page<Product> sortProductsBy(String direction, int index, int size, String... properties) {
        return productRepository.sortProductsBy(direction, index, size, properties);
    }

}
