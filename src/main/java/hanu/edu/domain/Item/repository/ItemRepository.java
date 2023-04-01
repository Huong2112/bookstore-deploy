package hanu.edu.domain.Item.repository;

import hanu.edu.domain.Item.model.Item;

import java.util.List;

public interface ItemRepository {
    public void save(Item item);
    public List<Item> getByProductId(long productId);
}
