package hanu.edu.domain.product.service;

import hanu.edu.domain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {
    @Autowired
    private ProductRepository productRepository;

    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
