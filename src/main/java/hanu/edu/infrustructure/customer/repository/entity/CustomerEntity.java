package hanu.edu.infrustructure.customer.repository.entity;

import hanu.edu.domain.customer.model.Phone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "customer")
@Entity
public class CustomerEntity {
    @Id
    private long id;
    private String name;
    private int age;
    private String address;
    private String avatar;
    private String phone;
}
