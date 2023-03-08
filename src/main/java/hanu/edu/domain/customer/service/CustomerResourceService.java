package hanu.edu.domain.customer.service;

import hanu.edu.domain.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//CRUD methods
@Service
public class CustomerResourceService {

    @Autowired
    private CustomerRepository customerRepository;



}
