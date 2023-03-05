package hanu.edu.domain.product.service;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class SearchProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getById(long id) {
        return productRepository.getById(id);
    }

    public Page<Product> get(int page, int size) {
        return productRepository.get(page, size);
    }
}
