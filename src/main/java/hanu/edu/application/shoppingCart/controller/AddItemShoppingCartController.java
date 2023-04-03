package hanu.edu.application.shoppingCart.controller;

import hanu.edu.domain.item.model.Item;
import hanu.edu.domain.item.model.ItemDTO;
import hanu.edu.domain.shoppingCart.service.AddItemShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddItemShoppingCartController {
    @Autowired
    private AddItemShoppingCartService addToShoppingCartService;

    @PostMapping("/cart/{customerId}")
    public ResponseEntity<String> addToShoppingCart(@RequestBody ItemDTO itemDTO, @PathVariable long customerId) {
        addToShoppingCartService.addToShoppingCart(new Item(itemDTO.getProductId(), itemDTO.getQuantity()), customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
