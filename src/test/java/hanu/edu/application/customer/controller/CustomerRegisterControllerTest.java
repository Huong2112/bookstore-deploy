//package hanu.edu.application.customer.controller;
//
//import hanu.edu.domain.customer.model.Customer;
//import hanu.edu.domain.customer.service.CustomerResourceService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@WebMvcTest
//class CustomerRegisterControllerTest {
//
//    @Autowired
//    CustomerResourceService customerResourceService;
//
//    @Autowired
//    BCryptPasswordEncoder encoder;
//
//    @Test
//    public static void main(String[] args) {
//        Customer customer = new Customer("newbie", "newbie@gmail.com", "newbie");
//        CustomerRegisterController customerRegisterController = new CustomerRegisterController();
//        assertEquals(new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED),
//                customerRegisterController.register(customer));
//    }
//}