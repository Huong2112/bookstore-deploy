package hanu.edu.infrastructure.shoppingCart.repository;

import hanu.edu.domain.shoppingCart.model.ShoppingCart;
import hanu.edu.domain.shoppingCart.repository.ShoppingCartRepository;
import hanu.edu.infrastructure.shoppingCart.entity.ShoppingCartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartRepositoryImpl implements ShoppingCartRepository {
    @Autowired
    private ShoppingCartJPARepository shoppingCartJPARepository;

    @Override
    public void save(ShoppingCart shoppingCart) {
        shoppingCartJPARepository.save(ShoppingCartEntity.toEntity(shoppingCart));
    }

    @Override
    public ShoppingCart getByCustomerId(long customerId) {
        return shoppingCartJPARepository.findByCustomerId(customerId).toShoppingCart();
    }
}
