package hanu.edu.domain.product.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private long id;
    private String name;
    private double price;
    private String description;
    private long inStock;
    private List<String> images;
    private String category;

    public Product(String name, double price, String description, long inStock, List<String> images, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.inStock = inStock;
        this.images = images;
        this.category = category;
    }
}
