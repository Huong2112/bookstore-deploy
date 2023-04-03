package hanu.edu.domain.shoppingCart.service;

import hanu.edu.domain.item.model.Item;
import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import hanu.edu.domain.shoppingCart.model.ShoppingCart;
import hanu.edu.domain.shoppingCart.repository.ShoppingCartRepository;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetItemsShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<OutputCart> getItem(long customerId) {
        ShoppingCart cart = shoppingCartRepository.getByCustomerId(customerId);
        List<OutputCart> outputCarts = new ArrayList<>();
        for (Item i : cart.getItems()) {
            Product product = productRepository.getById(i.getProductId());
            OutputCart outputCart = OutputCart.builder()
                    .productId(product.getId())
                    .description(product.getDescription())
                    .name(product.getName())
                    .price(product.getPrice())
                    .inStock(product.getInStock())
                    .images(product.getImages())
                    .category(product.getCategory())
                    .quantity(i.getQuantity()).build();
            outputCarts.add(outputCart);
        }
        return outputCarts;
    }
}

@Builder
@Getter
class OutputCart {
    private long quantity;
    private long productId;
    private String name;
    private double price;
    private String description;
    private long inStock;
    private List<String> images;
    private String category;
}
