package hanu.edu.application.customer.controller;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.service.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerUpdateController {

    @Autowired
    private UpdateCustomerService updateCustomerService;

    @PutMapping("/update/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable long customerId, @RequestBody Customer customer) {
        updateCustomerService.updateCustomer(customerId, customer);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

}
