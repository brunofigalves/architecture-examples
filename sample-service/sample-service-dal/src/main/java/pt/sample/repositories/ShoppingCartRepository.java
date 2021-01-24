package pt.sample.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.sample.models.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

    ShoppingCart findShoppingCartByUserId(String userId);

}
