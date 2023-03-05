package hanu.edu.infrustructure.product.controller;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.service.SearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchProductController {

    @Autowired
    private SearchProductService searchProductService;

    @GetMapping("/product/{id}")
    public Product getById(@PathVariable long id) {
        return searchProductService.getById(id);
    }

    @GetMapping("/product/{page}/{size}")
    public Page<Product> get(@PathVariable int page, @PathVariable int size) {
        return searchProductService.get(page, size);
    }
}
