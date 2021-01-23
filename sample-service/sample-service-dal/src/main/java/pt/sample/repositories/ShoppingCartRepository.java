package pt.sample.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pt.sample.models.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

    @Query("select s from shopping_cart where user_id := userId")
    ShoppingCart findShoppingCartByUser(String userId);

}
