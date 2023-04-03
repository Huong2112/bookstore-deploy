package hanu.edu.domain.security.service;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.domain.customer.service.CustomerResourceService;
import hanu.edu.domain.security.dto.BaseResponseDTO;
import hanu.edu.domain.security.dto.UserDTO;
import hanu.edu.domain.security.exception.BaseException;
import hanu.edu.domain.shoppingCart.model.ShoppingCart;
import hanu.edu.domain.shoppingCart.repository.ShoppingCartRepository;
import hanu.edu.domain.user.model.User;
import hanu.edu.domain.user.repository.UserRepository;
import hanu.edu.infrastructure.admin.entity.AdminEntity;
import hanu.edu.infrastructure.user.entity.UserEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private CustomerResourceService customerResourceService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public BaseResponseDTO registerAccount(UserDTO userDTO) {
        BaseResponseDTO response = new BaseResponseDTO();
        validateAccount(userDTO);
        Customer customer = insertUser(userDTO);
        try {
            // create user
            customerResourceService.create(customer);
            // create user's cart
            Customer customerFromDB = customerRepository.getByEmail(customer.getEmail());
            shoppingCartRepository.save(new ShoppingCart(customerFromDB.getId(), null));
            response.setCode(String.valueOf(HttpStatus.CREATED.value()));
            response.setMessage("Register account successfully!");
        // lost connection :v
        } catch (Exception e) {
            response.setCode(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()));
            response.setMessage("Service unavailable!");
        }
        return response;
    }

    private Customer insertUser(UserDTO userDTO) {
        Customer customer = new Customer();
        customer.setUsername(userDTO.getUsername());
        customer.setPassword(encoder.encode(userDTO.getPassword()));
        customer.setEmail(userDTO.getEmail());
        customer.setRole("ROLE_CUSTOMER");
        customer.setEnabled(true);
        return customer;
    }

    private void validateAccount(UserDTO userDTO) {
        // check if request is empty or null
        if (ObjectUtils.isEmpty(userDTO)) {
            throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Request data not found!");
        }

        try {
            // check if fields are existed and are set
            if (!ObjectUtils.isEmpty(userDTO.checkProperties())) {
                throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "Request data not found!");
            }
        } catch (IllegalAccessException e) {
            // if a field is not existed | null
            throw new BaseException(String.valueOf(HttpStatus.SERVICE_UNAVAILABLE.value()), "Service unavailable!!");
        }

        Optional<UserEntity> userEntity = userRepository.findByUsername(userDTO.getUsername());
        // check if user exists
        if (userEntity.isPresent()) {
            User user = userEntity.get().toUser();
            if (!ObjectUtils.isEmpty(user)) {
                throw new BaseException(String.valueOf(HttpStatus.BAD_REQUEST.value()), "User had existed!");
            }
        }
    }

    @Override
    @Transactional
    public void generateUsersRoles() {
        // Test admin
        if (userRepository.findByUsername("root").isEmpty()) {
            AdminEntity adminEntity = new AdminEntity("root", encoder.encode("root"), "root@gmail.com");
            userRepository.save(adminEntity);
        }
    }
}