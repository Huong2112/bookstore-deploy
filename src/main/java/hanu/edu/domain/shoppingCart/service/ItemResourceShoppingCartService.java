package hanu.edu.domain.shoppingCart.service;

import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
import hanu.edu.domain.shoppingCart.model.Item;
import hanu.edu.domain.shoppingCart.model.ShoppingCart;
import hanu.edu.domain.shoppingCart.repository.ShoppingCartRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemResourceShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addToShoppingCart(Item item, long customerId) {
        ShoppingCart cart = shoppingCartRepository.getByCustomerId(customerId);
        List<Item> items = cart.getItems();
        boolean inCart = false;
        if (items != null) {
            for (Item i : items) {
                if (i.getProductId() == item.getProductId()) {
                    i.setQuantity(item.getQuantity() + i.getQuantity());
                    inCart = true;
                    break;
                }
            }
            if (!inCart) {
                items.add(item);
            }
        } else {
            items = new ArrayList<>();
            items.add(item);
        }
        cart.setItems(items);
        shoppingCartRepository.save(cart);
    }

    @Transactional
    public void deleteItem(long productId, long customerId) {
        ShoppingCart shoppingCart = shoppingCartRepository.getByCustomerId(customerId);
        List<Item> items = shoppingCart.getItems();
        if (items != null) {
            for (Item i : items) {
                if (i.getProductId() == productId) {
                    items.remove(i);
                    shoppingCart.setItems(items);
                    shoppingCartRepository.save(shoppingCart);
                    break;
                }
            }
        }
    }

    public void updateItem(long customerId, long productId, long quantity) {
        ShoppingCart cart = shoppingCartRepository.getByCustomerId(customerId);
        List<Item> items = cart.getItems();
        if (items != null) {
            for (Item i : items) {
                if (i.getProductId() == productId) {
                    i.setQuantity(quantity);
                    cart.setItems(items);
                    shoppingCartRepository.save(cart);
                    break;
                }
            }
        }
    }

    public List<OutputCart> getItems(long customerId) {
        ShoppingCart cart = shoppingCartRepository.getByCustomerId(customerId);
        List<OutputCart> outputCarts = new ArrayList<>();
        for (Item i : cart.getItems()) {
            Product product = productRepository.getById(i.getProductId());
            if (product != null) {
                OutputCart outputCart = OutputCart.builder()
                        .productId(product.getId())
                        .description(product.getDescription())
                        .name(product.getName())
                        .price(product.getPrice())
                        .inStock(product.getInStock())
                        .images(product.getImages())
                        .category(product.getCategory())
                        .discount(product.getDiscount())
                        .quantity(i.getQuantity()).build();
                outputCarts.add(outputCart);
            }
        }
        return outputCarts;
    }

    public int countItems(long customerId) {
        ShoppingCart cart = shoppingCartRepository.getByCustomerId(customerId);
        return cart.getItems().size();
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
    private int discount;
}


