package hanu.edu.application.customer.controller;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.model.CustomerDTO;
import hanu.edu.domain.customer.service.CustomerResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerResourceController {

    @Autowired
    private CustomerResourceService customerResourceService;
    @GetMapping("/account")
    public Customer getCustomerAccount() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return (Customer) customerResourceService.getByUsername(username).get();
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable long customerId, @Validated @RequestBody CustomerDTO customerDTO) {
        customerResourceService.update(new Customer(customerId, customerDTO.getUsername(), customerDTO.getEmail(), customerDTO.getPassword(), customerDTO.getAddress(), customerDTO.getPhone(), customerDTO.getAvatar()));
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long customerId) {
        customerResourceService.deleteById(customerId);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
