package hanu.edu.domain.product.service;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import hanu.edu.domain.security.exception.BaseException;
import hanu.edu.infrastructure.product.entity.ProductEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//CRUD methods
@Service
@AllArgsConstructor
public class ProductResourceService {

    private final ProductRepository productRepository;

    public void create(Product product) {
        Product productFromDB = productRepository.getByName(product.getName());
        if (productFromDB != null) {
            throw new BaseException("500", "Duplicate name");
        }
        productRepository.save(ProductEntity.toEntity(product));
    }

    public void update(Product product) {
        productRepository.save(ProductEntity.toEntity(product));
    }

    public Product getById(long id) {
        return productRepository.getById(id);
    }

    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> getAllByPage(int page) {
        return productRepository.getAllProductsByPage(page, 20);
    }

    public Page<Product> getAllByCategory(int page, String category) {
        return productRepository.getProductByCategory(page, 20, category);
    }
}
