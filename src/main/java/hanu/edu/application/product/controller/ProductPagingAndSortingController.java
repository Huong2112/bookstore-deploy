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

    @GetMapping({"/{index}", "/"})
    public Page<Product> getProductsSorted(@PathVariable(name = "index") Optional<Integer> index, @PathParam("direction") String direction, @PathParam("price") boolean price) {
        int page;
        if (!index.isPresent()) page = 0;
        else page = index.get();
        if (price == true && direction != null && !direction.isEmpty()) {
            return productPagingAndSortingService.sortProductsBy(direction, page, 20, "price");
        } else if (price == true) {
            return productPagingAndSortingService.sortProductsBy("asc", page, 20, "price");
        } else if (direction != null && !direction.isEmpty()) {
            return productPagingAndSortingService.sortProductsBy(direction, page, 20, "name");
        } else {
            return productPagingAndSortingService.getAllProductsByPage(page, 20);
        }
    }

    @GetMapping({"/search", "/search/{index}"})
    public Page<Product> getProductsByName(@PathVariable(name = "index") Optional<Integer> index, @PathParam("name") String name) {
        int page;
        if (!index.isPresent()) page = 0;
        else page = index.get();
        if (name != null && !name.isEmpty()) {
            return productPagingAndSortingService.searchProductsByName(page, 20, name);
        } else {
            return productPagingAndSortingService.getAllProductsByPage(page, 20);
        }
    }
}
