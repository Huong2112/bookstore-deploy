package hanu.edu.infrastructure.item.repository;

import hanu.edu.domain.item.model.Item;
import hanu.edu.domain.item.repository.ItemRepository;
import hanu.edu.infrastructure.item.entity.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    @Autowired
    private ItemJPARepository itemJPARepository;

    @Override
    public void save(Item item) {
        itemJPARepository.save(ItemEntity.toEntity(item));
    }

    @Override
    public List<Item> getByProductId(long productId) {
        return itemJPARepository.findByProductId(productId).stream().map(ItemEntity::toItem).collect(Collectors.toList());
    }

    @Override
    public void deleteByItemId(long itemId) {
        itemJPARepository.deleteByItemId(itemId);
    }

    @Override
    public Item getByItemId(long itemId) {
        return itemJPARepository.findById(itemId).get().toItem();
    }
}
