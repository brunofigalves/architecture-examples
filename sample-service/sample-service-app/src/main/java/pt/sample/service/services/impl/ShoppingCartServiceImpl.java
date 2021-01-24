package pt.sample.service.services.impl;

import pt.sample.models.Item;
import pt.sample.models.Quantity;
import pt.sample.models.ShoppingCart;
import pt.sample.repositories.ShoppingCartRepository;
import pt.sample.service.services.ProductsService;
import pt.sample.service.services.ShoppingCartService;
import pt.sample.service.services.dtos.AddItemDto;
import pt.sample.service.services.dtos.ItemDto;
import pt.sample.service.services.dtos.ProductDto;
import pt.sample.service.services.dtos.ShoppingCartDto;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

@ApplicationScoped
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Resource
    private ProductsService productsService;

    @Resource
    private ShoppingCartRepository shoppingCartRepository;

    private final CurrencyUnit eur = Monetary.getCurrency("EUR");

    @Override
    public ItemDto addItem(AddItemDto dto) {

        // Getting or creating a shopping cart for an user
        ShoppingCart shoppingCart = this.shoppingCartRepository.findShoppingCartByUserId(dto.getUserId());
        if(shoppingCart == null) {
            shoppingCart = ShoppingCart.newShoppingCart(dto.getUserId());
        }

        // Get product from product service
        ProductDto productDto = this.productsService.getProduct(dto.getProductId());

        // Create item based on product
        Item item = this.createItemFrom(productDto, dto.getQuantity());

        // Add new item to shopping cart
        shoppingCart.addItem(item);
        this.shoppingCartRepository.save(shoppingCart);

        return ItemDto.builder()
                .productId(item.getProductId())
                .quantity(item.getQuantity().value())
                .price(item.getPrice().getNumber().doubleValue())
                .build();
    }

    @Override
    public void removeItem(String productId) {
    }

    @Override
    public ShoppingCartDto getShoppingCartByUserId(String userId) {
        return null;
    }

    private Item createItemFrom(ProductDto productDto, Integer quantity) {
        MonetaryAmount price = Monetary.getDefaultAmountFactory()
                .setCurrency(eur)
                .setNumber(productDto.getPrice())
                .create();

        Item item;
        try {
            item = Item.newItem(productDto.getProductId(), price);
            item.addQuantity(Quantity.valueOf(quantity));
        } catch (Exception e) {
            return null;
        }

        return item;
    }
}
