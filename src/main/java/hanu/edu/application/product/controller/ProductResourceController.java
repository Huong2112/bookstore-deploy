package hanu.edu.application.product.controller;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.service.ProductResourceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getById(@RequestParam long id) {
        return new ResponseEntity<>(productResourceService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public void deleteById(@RequestParam long id) {
        productResourceService.deleteById(id);
    }
}
