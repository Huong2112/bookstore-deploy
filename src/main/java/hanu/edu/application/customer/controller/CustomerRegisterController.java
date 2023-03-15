package hanu.edu.application.customer.controller;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.service.CustomerResourceService;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import hanu.edu.infrastructure.customer.repository.CustomerRepositoryImpl;
import hanu.edu.infrastructure.share.GlobalExceptionHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRegisterController {

    @Autowired
    CustomerResourceService customerResourceService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody Customer customer) {
        String encodedPassword = encoder.encode(customer.getPassword());
        customer.setPassword(encodedPassword);
        customerResourceService.create(customer);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }
}

