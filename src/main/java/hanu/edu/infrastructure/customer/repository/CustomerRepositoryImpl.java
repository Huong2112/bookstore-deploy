package hanu.edu.infrastructure.customer.repository;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    private CustomerJPARepository customerJPARepository;

    @Override
    public void save(Customer customer) {
        customerJPARepository.save(CustomerEntity.toEntity(customer));
    }

    @Override
    public Customer getByEmail(String email) {
        return customerJPARepository.findByEmail(email).toCustomer();
    }


    @Override
    public void deleteById(long id) {
        customerJPARepository.deleteById(id);
    }

    @Override
    public void save(CustomerEntity customerEntity) {
        customerJPARepository.save(customerEntity);
    }

    @Override
    public CustomerEntity getByCustomerId(long customerId) {
        return customerJPARepository.getById(customerId);
    }


}
