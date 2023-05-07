package hanu.edu.application.customer.controller;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.model.CustomerDTO;
import hanu.edu.domain.customer.service.CustomerResourceService;
import hanu.edu.domain.s3config.Response;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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

    @GetMapping("/customer/{customerId}")
    public Customer getCustomerAccount(@PathVariable long customerId) {

        return customerResourceService.getById(customerId);
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable long customerId, @Valid @RequestBody CustomerDTO customerDTO) {
        String avatar = customerResourceService.getById(customerId).getAvatar();
        customerResourceService.update(new Customer(customerId, customerDTO.getUsername(), customerDTO.getEmail(), customerDTO.getPassword(), customerDTO.getAddress(), customerDTO.getPhone(), customerDTO.getAge(), avatar));
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping("/customer/update-avatar/{customerId}")
    public ResponseEntity<Response> updateAvatar(@PathVariable long customerId, @RequestParam("file") MultipartFile file) {
        customerResourceService.changeAvatar(customerId, file);
        return ResponseEntity.ok(
                Response.builder()
                        .status(200)
                        .message("Change avatar successfully")
                        .build());
    }

//    @DeleteMapping("/customer/{customerId}")
//    public ResponseEntity<String> deleteCustomer(@PathVariable long customerId) {
//        customerResourceService.deleteById(customerId);
//        return new ResponseEntity<>("Success", HttpStatus.OK);
//    }
}
