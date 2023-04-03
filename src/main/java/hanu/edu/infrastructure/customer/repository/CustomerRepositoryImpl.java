package hanu.edu.infrastructure.customer.repository;

import hanu.edu.domain.customer.model.Customer;
import hanu.edu.domain.customer.repository.CustomerRepository;
import hanu.edu.infrastructure.customer.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    public Customer getByCustomerId(long customerId) {
        Optional<CustomerEntity> findCustomer = customerJPARepository.findById(customerId);
        return findCustomer.map(CustomerEntity::toCustomer).orElse(null);
    }

//    @Override
//    public long getIdCustomer(Customer customer) {
//        return customer.getId();
//    }

    @Override
    public void deleteByCustomerId(long customerId) {
        customerJPARepository.deleteById(customerId);
    }

    @Override
    public void updateByCustomerId(long customerId, Customer customer) {
        if (customer.getId() == customerId) {
            customer.setId(customerId);
            customerJPARepository.save(CustomerEntity.toEntity(customer));
        }
    }
}
