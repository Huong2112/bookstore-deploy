package hanu.edu.infrastructure.product.repository;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import hanu.edu.infrastructure.product.repository.entity.ProductEntity;
import hanu.edu.infrastructure.product.repository.jpa.ProductJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductJPARepository productJPARepository;
    @Override
    public Product getById(long id) {
        return productJPARepository.findById(id).orElseThrow().toProduct();
    }

    @Override
    public void save(ProductEntity productEntity) {
        productJPARepository.save(productEntity);
    }

    @Override
    public void deleteById(long id) {
        productJPARepository.deleteById(id);
    }

    public Page<Product> get(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return productJPARepository.findAll(pageRequest).map(x -> x.toProduct());
    }
}
