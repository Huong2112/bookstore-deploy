package hanu.edu.application.product.controller;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.model.ProductDTO;
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

    @PostMapping("/admin/product")
    public ResponseEntity<String> create(@RequestBody ProductDTO productDTO) {
        productResourceService.create(new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getDescription(),
                productDTO.getInStock(), productDTO.getImages(), productDTO.getCategory()));
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return new ResponseEntity<>(productResourceService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/admin/product/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        productResourceService.deleteById(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PutMapping("/admin/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @Valid @RequestBody ProductDTO productDTO) {
        productResourceService.update(new Product(id, productDTO.getName(), productDTO.getPrice(), productDTO.getDescription(),
                productDTO.getInStock(), productDTO.getImages(), productDTO.getCategory()));
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/admin/product/{page}/{totalPage}")
    public ResponseEntity<?> getAll(@PathVariable int page, @PathVariable int totalPage) {
        return new ResponseEntity<>(productResourceService.getAllByPage(page, totalPage),HttpStatus.OK);
    }
}
