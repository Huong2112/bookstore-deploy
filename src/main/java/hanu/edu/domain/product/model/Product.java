package hanu.edu.domain.product.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Product {
    private long id;
    @NotNull(message = "Name can't be null")
    private String name;
    @Min(value = 0, message = "Price can't not be less than 0")
    private double price;
    private String description;
    @Min(value = 0, message = "Number of product in stock can't not be less than 0")
    private long inStock;
    private List<String> images;
    @Min(value = 1, message = "Rate has to be equal or greater than 1")
    @Max(value = 5, message = "Rate has to be equal or less than 5")
    private float rate;
}
