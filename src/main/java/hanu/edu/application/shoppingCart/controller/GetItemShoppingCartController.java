package hanu.edu.application.shoppingCart.controller;

import hanu.edu.domain.shoppingCart.service.GetItemsShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetItemShoppingCartController {
    @Autowired
    private GetItemsShoppingCartService getItemsShoppingCartService;

    @GetMapping("/cart/{customerId}")
    public ResponseEntity<?> getItem(@PathVariable long customerId) {
        return new ResponseEntity<>(getItemsShoppingCartService.getItem(customerId), HttpStatus.OK);
    }
}
