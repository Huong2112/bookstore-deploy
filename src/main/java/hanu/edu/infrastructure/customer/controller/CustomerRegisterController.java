package hanu.edu.infrastructure.customer.controller;

import hanu.edu.infrastructure.customer.repository.entity.CustomerEntity;
import hanu.edu.infrastructure.customer.repository.CustomerJPARepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRegisterController {

    @Autowired
    CustomerJPARepository customerJPARepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping(value = "/register")
    public String registerForm(@ModelAttribute("customer") CustomerEntity customerEntity, Model model) {
        model.addAttribute("customer", customerEntity);
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(@Valid CustomerEntity customerEntity, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        String encodedPassword = encoder.encode(customerEntity.getPassword());
        customerEntity.setPassword(encodedPassword);
        customerJPARepository.saveAndFlush(customerEntity);
        return "redirect:/";
    }

}

