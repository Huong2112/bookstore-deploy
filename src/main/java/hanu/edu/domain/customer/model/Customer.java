package hanu.edu.domain.customer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Customer {
    private long id;
    private String name;
    private int age;
    private String address;
    private String avatar;
    private Phone phone;
}
