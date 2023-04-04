package hanu.edu.infrastructure.product.repository;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import hanu.edu.infrastructure.product.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Product getByName(String name) {
        ProductEntity productEntity = productJPARepository.findByName(name);
        return productEntity == null ? null : productEntity.toProduct();
    }

    @Override
    public void deleteById(long id) {
        productJPARepository.deleteById(id);
    }

    @Override
    public Page<Product> getAllProductsByPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return productJPARepository.findAll(pageRequest).map(ProductEntity::toProduct);
    }

    @Override
    public Page<Product> searchProductsByName(int page, int size, String name) {
        Pageable pageRequest = PageRequest.of(page, size);
        return productJPARepository.findAllByNameContaining(name, pageRequest).map(ProductEntity::toProduct);
    }

    @Override
    public Page<Product> sortProductsBy(int page, int size, String direction, String... properties) {
        PageRequest pageRequest;
        if (direction.equals("asc")) {
            pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, properties);
        } else if (direction.equals("desc")) {
            pageRequest = PageRequest.of(page, size, Sort.Direction.DESC, properties);
        } else {
            pageRequest = PageRequest.of(page, size, Sort.DEFAULT_DIRECTION, properties);
        }
        return productJPARepository.findAll(pageRequest).map(ProductEntity::toProduct);
    }
}
