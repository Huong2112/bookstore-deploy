package hanu.edu.application.shoppingCart.controller;

import hanu.edu.domain.shoppingCart.service.DeleteItemShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteItemShoppingCartController {

    @Autowired
    private DeleteItemShoppingCartService deleteItemShoppingCartService;

    @DeleteMapping("/cart")
    public ResponseEntity<String> deleteItem(@RequestParam long productId, @RequestParam long customerId) {
        deleteItemShoppingCartService.deleteItem(productId, customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
