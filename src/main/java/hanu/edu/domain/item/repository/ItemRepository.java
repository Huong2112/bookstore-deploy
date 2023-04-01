package hanu.edu.domain.item.repository;

import hanu.edu.domain.item.model.Item;

import java.util.List;

public interface ItemRepository {
    public void save(Item item);

    public List<Item> getByProductId(long productId);

    void deleteByItemId(long itemId);
}
