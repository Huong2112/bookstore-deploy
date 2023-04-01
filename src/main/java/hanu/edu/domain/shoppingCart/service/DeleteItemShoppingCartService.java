package hanu.edu.domain.shoppingCart.service;

import hanu.edu.domain.item.model.Item;
import hanu.edu.domain.item.repository.ItemRepository;
import hanu.edu.domain.shoppingCart.model.ShoppingCart;
import hanu.edu.domain.shoppingCart.repository.ShoppingCartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteItemShoppingCartService {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public void deleteItem(long productId, long customerId) {
        ShoppingCart shoppingCart = shoppingCartRepository.getByCustomerId(customerId);
        List<Item> items = shoppingCart.getItems();
        if(items != null) {
            for(Item i: items) {
                if(i.getProductId() == productId) {
                    items.remove(i);
                    shoppingCart.setItems(items);
                    itemRepository.deleteByItemId(i.getItemId());
                    shoppingCartRepository.save(shoppingCart);
                    break;
                }
            }
        }
    }
}
