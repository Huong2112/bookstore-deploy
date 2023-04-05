package hanu.edu.domain.item.service;

import hanu.edu.domain.item.model.Item;
import hanu.edu.domain.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateItemShoppingCartService {

    @Autowired
    private ItemRepository itemRepository;

    public void updateItem(long quantity, long itemId) {
        Item item = itemRepository.getByItemId(itemId);
        item.setQuantity(quantity);
        itemRepository.save(item);
    }
}
