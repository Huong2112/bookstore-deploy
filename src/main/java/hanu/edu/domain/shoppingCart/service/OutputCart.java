package hanu.edu.domain.shoppingCart.service;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class OutputCart {
    private long quantity;
    private long productId;
    private String name;
    private double price;
    private String description;
    private long inStock;
    private List<String> images;
    private String category;
    private int discount;

    public double getTotalPrice() {
        return price*quantity;
    }
}
