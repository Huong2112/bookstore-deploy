package hanu.edu.infrastructure.item.repository;

import hanu.edu.infrastructure.item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemJPARepository extends JpaRepository<ItemEntity, Long> {
    List<ItemEntity> findByProductId(long productId);

    void deleteByItemId(long itemId);
}
