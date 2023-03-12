package hanu.edu.infrastructure.user.controller;

import hanu.edu.infrastructure.role.repository.jpa.RoleJPARepository;
import hanu.edu.infrastructure.user.repository.entity.UserEntity;
import hanu.edu.infrastructure.user.repository.jpa.UserJPARepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    UserJPARepository userJPARepository;

    @Autowired
    RoleJPARepository roleJPARepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping(value = "/register")
    public String registerForm(@ModelAttribute("user") UserEntity user, Model model) {
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value = "/register")
    public String register(@Valid UserEntity user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        user.addRole(roleJPARepository.getReferenceById(Long.valueOf(2)));
        user.setEnabled(true);
        userJPARepository.save(user);
        return "redirect:/";
    }

}

