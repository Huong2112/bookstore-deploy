package hanu.edu.domain.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Product {
    private long id;
    private String name;
    private double price;
    private String description;
    private long inStock;
    private List<String> images;
    private float rate;
}
