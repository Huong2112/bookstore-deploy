package hanu.edu.domain.shoppingCart.repository;

import hanu.edu.domain.shoppingCart.model.ShoppingCart;

public interface ShoppingCartRepository {
    public void save(ShoppingCart shoppingCart);

    public ShoppingCart getByCustomerId(long customerId);
}
