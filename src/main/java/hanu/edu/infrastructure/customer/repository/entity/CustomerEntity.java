package hanu.edu.infrastructure.customer.repository.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "customer")
@Table(name = "customer")

public class CustomerEntity {
    @Id
    private long id;
    private String name;
    private int age;
    private String address;
    private String avatar;
    private String phone;
}
