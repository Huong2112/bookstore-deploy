package hanu.edu.application.product.controller;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.model.ProductDTO;
import hanu.edu.domain.product.service.ProductResourceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductResourceController {

    @Autowired
    private final ProductResourceService productResourceService;

    @PostMapping("/admin/product")
    public ResponseEntity<String> create(@RequestBody ProductDTO productDTO) {
        productResourceService.create(new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getDescription(),
                productDTO.getInStock(), productDTO.getImages(), productDTO.getCategory(), productDTO.getDiscount()));
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/admin/product-image-upload/{id}")
    public ResponseEntity<String> uploadImages(@RequestParam("image") List<MultipartFile> productImages, @PathVariable long id) {
        productResourceService.uploadImages(id, productImages);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public Product getById(@PathVariable long id) {
        return productResourceService.getById(id);
    }

    @DeleteMapping("/admin/product/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        productResourceService.deleteById(id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PutMapping("/admin/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable long id, @Valid @RequestBody ProductDTO productDTO) {
        List<String> images = productResourceService.getById(id).getImages();
        productResourceService.update(new Product(id, productDTO.getName(), productDTO.getPrice(), productDTO.getDescription(),
                productDTO.getInStock(), images, productDTO.getCategory(), productDTO.getDiscount()));
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/admin/product/{page}")
    public ResponseEntity<?> getAll(@PathVariable int page) {
        return new ResponseEntity<>(productResourceService.getAllByPage(page), HttpStatus.OK);
    }

    @GetMapping("/product/{category}/{page}")
    public ResponseEntity<?> getByCategory(@PathVariable String category, @PathVariable int page) {
        return new ResponseEntity<>(productResourceService.getAllByCategory(page, category), HttpStatus.OK);
    }
}
