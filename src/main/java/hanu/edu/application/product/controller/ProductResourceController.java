package hanu.edu.application.product.controller;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.service.ProductResourceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductResourceController {
    @Autowired
    private ProductResourceService productResourceService;

    @PostMapping("/product")
    public void create(@Valid @RequestBody Product product) {
        productResourceService.create(product);
    }

    @GetMapping("/product")
    public Product getById(@RequestParam long id) {
        return productResourceService.getById(id);
    }

    @DeleteMapping("/product")
    public void deleteById(@RequestParam long id) {
        productResourceService.deleteById(id);
    }
}
