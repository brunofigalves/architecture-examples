package pt.sample.models;

import pt.sample.exceptions.SampleServiceException;

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

    public Long getId() {
        return id;
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public String getUserId() {
        return userId;
    }

    public Set<Item> getItems() {
        return items;
    }

    public static ShoppingCart newShoppingCart(String userId) {
        return new ShoppingCart(UUID.randomUUID().toString(), userId);
    }

    public void addItem(Item i) throws SampleServiceException{
        if (items.contains(i)){
            throw new SampleServiceException(String.format("Product id %s already exist", i.getProductId()));
        }
        items.add(i);
    }

    public void increaseItemQuantity(String productId, Quantity quantity) throws SampleServiceException {
        getItem(productId).getQuantity().add(quantity);
    }

    public Item getItem(String productId) {
        return items.stream()
                .filter(e -> e.getProductId().equals(productId))
                .findAny().orElse(null);
    }

    public Double getTotalPrice() {
        return items.stream()
                .mapToDouble(e -> e.getPrice().getNumber().doubleValue())
                .sum();
    }

    public Integer getTotalQuantity() {
        return items.stream()
                .mapToInt(e -> e.getQuantity().value()).sum();
    }
}
