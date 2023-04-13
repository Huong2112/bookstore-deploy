package hanu.edu.application.product.controller;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.service.ProductPagingAndSortingService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductPagingAndSortingController {
    @Autowired
    private ProductPagingAndSortingService productPagingAndSortingService;

    @GetMapping({"/{pageNo}", "/"})
    public Page<Product> getProductsBy(@PathVariable(name = "pageNo") Optional<Integer> pageNo, @PathParam("direction") String direction,
                                       @PathParam("price") boolean price, @PathParam("name") boolean name, @PathParam("category") boolean category, @PathParam("inStock") boolean inStock) {
        int page;
        if (!pageNo.isPresent()) page = 0;
        else page = pageNo.get();
        if (direction == null || direction.isEmpty()) direction = "asc";
        if (price == true) {
            return productPagingAndSortingService.sortProductsBy(page, 20, direction, "price");
        } else if (name == true) {
            return productPagingAndSortingService.sortProductsBy(page, 20, direction, "name");
        } else if (category == true) {
            return productPagingAndSortingService.sortProductsBy(page, 20, direction, "category");
        } else if (inStock == true) {
            return productPagingAndSortingService.sortProductsBy(page, 20, direction, "inStock");
        } else {
            return productPagingAndSortingService.getAllProductsByPage(page, 20);
        }
    }

    @GetMapping({"/search", "/search/{pageNo}"})
    public Page<Product> getProductsByName(@PathVariable(name = "pageNo") Optional<Integer> pageNo, @PathParam("name") String name) {
        int page;
        if (!pageNo.isPresent()) page = 0;
        else page = pageNo.get();
        if (name != null && !name.isEmpty()) {
            return productPagingAndSortingService.searchProductsByName(page, 20, name);
        } else {
            return productPagingAndSortingService.getAllProductsByPage(page, 20);
        }
    }
}
