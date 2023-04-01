package hanu.edu.domain.shoppingCart.service;

import hanu.edu.domain.Item.model.Item;
import hanu.edu.domain.Item.repository.ItemRepository;
import hanu.edu.domain.shoppingCart.model.ShoppingCart;
import hanu.edu.domain.shoppingCart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddToShoppingCartService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    public void addToShoppingCart(Item item, long customerId) {
        ShoppingCart cart = shoppingCartRepository.getByCustomerId(customerId);
        List<Item> items = cart.getItems();
        boolean inCart = false;
        for(Item i: items) {
            if(i.getProductId() == item.getProductId()) {
                i.setQuantity(i.getQuantity() + item.getQuantity());
                itemRepository.save(i);
                inCart = true;
                break;
            }
        }
        if(!inCart) {
            items.add(item);
            itemRepository.save(item);
        }
        cart.setItems(items);
        shoppingCartRepository.save(cart);
    }
}