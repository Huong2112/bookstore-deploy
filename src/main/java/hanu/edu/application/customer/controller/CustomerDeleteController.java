package hanu.edu.application.customer.controller;

import hanu.edu.domain.customer.service.DeleteCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerDeleteController {

    @Autowired
    private DeleteCustomerService deleteCustomerService;

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long customerId) {
        deleteCustomerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
