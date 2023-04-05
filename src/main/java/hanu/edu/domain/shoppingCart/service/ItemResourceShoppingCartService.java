package hanu.edu.domain.shoppingCart.service;

import hanu.edu.domain.item.model.Item;
import hanu.edu.domain.item.repository.ItemRepository;
import hanu.edu.domain.product.model.Product;
import hanu.edu.domain.product.repository.ProductRepository;
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
    private ItemRepository itemRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addToShoppingCart(Item item, long customerId) {
        ShoppingCart cart = shoppingCartRepository.getByCustomerId(customerId);
        List<Item> items = cart.getItems();
        boolean inCart = false;
        for (Item i : items) {
            if (i.getProductId() == item.getProductId()) {
                i.setQuantity(item.getQuantity() + i.getQuantity());
                itemRepository.save(i);
                inCart = true;
                break;
            }
        }
        if (!inCart) {
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
                    itemRepository.deleteByItemId(i.getItemId());
                    shoppingCartRepository.save(shoppingCart);
                    break;
                }
            }
        }
    }

    public List<OutputCart> getItem(long customerId) {
        ShoppingCart cart = shoppingCartRepository.getByCustomerId(customerId);
        List<OutputCart> outputCarts = new ArrayList<>();
        for (Item i : cart.getItems()) {
            Product product = productRepository.getById(i.getProductId());
            if(product != null) {
                OutputCart outputCart = OutputCart.builder()
                        .itemId(i.getItemId())
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
        }
        return outputCarts;
    }
}

@Builder
@Getter
class OutputCart {
    private long itemId;
    private long quantity;
    private long productId;
    private String name;
    private double price;
    private String description;
    private long inStock;
    private List<String> images;
    private String category;
}


