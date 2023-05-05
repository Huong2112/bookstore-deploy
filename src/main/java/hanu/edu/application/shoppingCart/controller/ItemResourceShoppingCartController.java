package hanu.edu.application.shoppingCart.controller;

import hanu.edu.domain.shoppingCart.model.Item;
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
    public ResponseEntity<String> addToShoppingCart(@RequestBody Item item, @PathVariable long customerId) {
        itemResourceShoppingCartService.addToShoppingCart(item, customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/cart/{customerId}")
    public ResponseEntity<?> getItems(@PathVariable long customerId) {
        return new ResponseEntity<>(itemResourceShoppingCartService.getItems(customerId), HttpStatus.OK);
    }

    @DeleteMapping("/cart/{customerId}/{productId}")
    public ResponseEntity<String> deleteItem(@PathVariable long customerId, @PathVariable long productId) {
        itemResourceShoppingCartService.deleteItem(productId, customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping("/cart/{customerId}")
    public ResponseEntity<String> deleteAllItem(@PathVariable long customerId) {
        itemResourceShoppingCartService.deleteAllItems(customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PutMapping("/cart/{customerId}/{productId}/{quantity}")
    public ResponseEntity<String> updateItem(@PathVariable long customerId, @PathVariable long productId, @PathVariable long quantity) {
        itemResourceShoppingCartService.updateItem(customerId, productId, quantity);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/cart/count/{customerId}")
    public int countItem(@PathVariable long customerId) {
        return itemResourceShoppingCartService.countItems(customerId);
    }
}
