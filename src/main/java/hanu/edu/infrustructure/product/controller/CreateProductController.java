package hanu.edu.infrustructure.product.controller;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.service.CreateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateProductController {
    @Autowired
    private CreateProductService createProductService;

    @PostMapping("/product")
    public void create(@RequestBody Product product) {
        createProductService.create(product);
    }
}
