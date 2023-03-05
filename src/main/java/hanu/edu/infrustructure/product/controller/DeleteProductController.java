package hanu.edu.infrustructure.product.controller;

import hanu.edu.domain.product.service.DeleteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteProductController {
    @Autowired
    private DeleteProductService deleteProductService;

    @DeleteMapping("/product")
    public void delete(@RequestParam long id) {
        deleteProductService.delete(id);
    }
}
