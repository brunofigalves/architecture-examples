package pt.sample.models;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "PRODUCT_ID")
    private String productId;
    @Column(name = "PRICE")
    private Double price;
    @Embedded
    private Quantity quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="SHOPPING_CART_ID")
    private ShoppingCart shoppingCart;

    protected Item() {
        // Only for JPA purpose
    }

    public Item(String productId, MonetaryAmount price, Quantity quantity, ShoppingCart shoppingCart) throws Exception {
        if(!price.isPositiveOrZero()) {
            throw new Exception("Product can not cost less than 0 euros");
        }
        this.productId = productId.toString();
        this.price = price.getNumber().doubleValue();
        this.quantity = quantity;
        this.shoppingCart= shoppingCart;
    }
    
    public static Item newItem(String productId, MonetaryAmount price, ShoppingCart shoppingCart) throws Exception {
        return new Item(productId, price, Quantity.zero(), shoppingCart);
    }

    public void addQuantity(Quantity q) throws Exception {
        this.quantity.add(q);
    }

    public Long getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public MonetaryAmount getPrice() {
        return Monetary.getDefaultAmountFactory()
                .setCurrency("EUR")
                .setNumber(this.price)
                .create();
    }

}
