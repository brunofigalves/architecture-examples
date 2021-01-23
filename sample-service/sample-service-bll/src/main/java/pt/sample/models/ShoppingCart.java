package pt.sample.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "SHOPPING_CART")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SHOPPING_CART_ID", unique = true)
    private String shoppingCartId;
    @Column(name = "USER_ID", unique = true)
    private String userId;
    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
    @Column(name = "SHOPPING_CART")
    private Set<Item> items = new HashSet<>();

    protected ShoppingCart() {
        // Only for JPA purpose
    }

    public ShoppingCart(String shoppingCartId, String userId) {
        this.shoppingCartId = shoppingCartId;
        this.userId = userId;
    }

    public static ShoppingCart newShoppingCart(String userId) {
        return new ShoppingCart(UUID.randomUUID().toString(), userId);
    }

    public void addItem(Item i) {
        this.items.add(i);
    }
}
