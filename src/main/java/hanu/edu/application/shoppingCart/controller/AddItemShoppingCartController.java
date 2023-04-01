package hanu.edu.application.shoppingCart.controller;

import hanu.edu.domain.item.model.Item;
import hanu.edu.domain.shoppingCart.service.AddItemShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddItemShoppingCartController {
    @Autowired
    private AddItemShoppingCartService addToShoppingCartService;

    @PostMapping("/cart")
    public ResponseEntity<String> addToShoppingCart(@RequestBody Item item, @RequestParam long customerId) {
        addToShoppingCartService.addToShoppingCart(item, customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
