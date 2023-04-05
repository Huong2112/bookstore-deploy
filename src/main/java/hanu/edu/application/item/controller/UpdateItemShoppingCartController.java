package hanu.edu.application.item.controller;

import hanu.edu.domain.item.service.UpdateItemShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateItemShoppingCartController {
    @Autowired
    private UpdateItemShoppingCartService updateItemShoppingCartService;

    @PutMapping("/cart/{itemId}/{quantity}")
    public ResponseEntity<String> updateItemQuantity(@PathVariable long quantity, @PathVariable long itemId) {
        updateItemShoppingCartService.updateItem(quantity, itemId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
