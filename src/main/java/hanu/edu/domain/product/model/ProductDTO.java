package hanu.edu.domain.product.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDTO {
    @NotNull(message = "Name can't be null")
    private String name;
    @Min(value = 0, message = "Price can't not be less than 0")
    private double price;
    private String description;
    @Min(value = 0, message = "Number of products in stock can't not be less than 0")
    private long inStock;
    private List<String> images;
    private String category;
    @Min(value = 0, message = "Discount value can't not be less than 0")
    private int discount;
}
