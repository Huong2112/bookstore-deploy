package hanu.edu.infrastructure.shoppingCart.repository;

import hanu.edu.infrastructure.shoppingCart.entity.ShoppingCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartJPARepository extends JpaRepository<ShoppingCartEntity, Long> {
    ShoppingCartEntity findByCustomerId(long customerId);
}
