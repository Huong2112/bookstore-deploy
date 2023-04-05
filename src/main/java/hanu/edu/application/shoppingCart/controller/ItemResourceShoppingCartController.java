package hanu.edu.application.shoppingCart.controller;

import hanu.edu.domain.item.model.Item;
import hanu.edu.domain.item.model.ItemDTO;
import hanu.edu.domain.shoppingCart.service.ItemResourceShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemResourceShoppingCartController {
    @Autowired
    private ItemResourceShoppingCartService itemResourceShoppingCartService;

    @PostMapping("/cart/{customerId}")
    public ResponseEntity<String> addToShoppingCart(@RequestBody ItemDTO itemDTO, @PathVariable long customerId) {
        itemResourceShoppingCartService.addToShoppingCart(new Item(itemDTO.getProductId(), itemDTO.getQuantity()), customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/cart/{customerId}")
    public ResponseEntity<?> getItem(@PathVariable long customerId) {
        return new ResponseEntity<>(itemResourceShoppingCartService.getItem(customerId), HttpStatus.OK);
    }

    @DeleteMapping("/cart/{customerId}/{productId}")
    public ResponseEntity<String> deleteItem(@PathVariable long customerId, @PathVariable long productId) {
        itemResourceShoppingCartService.deleteItem(productId, customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
