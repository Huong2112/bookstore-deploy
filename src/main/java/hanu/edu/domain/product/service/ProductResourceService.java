package hanu.edu.domain.product.service;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import hanu.edu.infrastructure.product.repository.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//CRUD methods
@Service
public class ProductResourceService {
    @Autowired
    private ProductRepository productRepository;

    public void create(Product product) {
        productRepository.save(ProductEntity.toEntity(product));
    }

    public Product getById(long id) {
        return productRepository.getById(id);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
