package hanu.edu.infrastructure.Item.repository;

import hanu.edu.domain.Item.model.Item;
import hanu.edu.infrastructure.Item.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemJPARepository extends JpaRepository<ItemEntity, Long> {
    List<ItemEntity> findByProductId(long productId);
}
