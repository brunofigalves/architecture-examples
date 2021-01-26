package pt.sample.service.services.impl;

import pt.sample.exceptions.SampleServiceException;
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
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Resource
    private ProductsService productsService;

    @Resource
    private ShoppingCartRepository shoppingCartRepository;

    private final CurrencyUnit eur = Monetary.getCurrency("EUR");

    @Override
    @Transactional
    public ItemDto addItem(AddItemDto dto) throws SampleServiceException {

        // Getting or creating a shopping cart for an user
        ShoppingCart shoppingCart = this.shoppingCartRepository.findShoppingCartByUserId(dto.getUserId());
        if (shoppingCart == null) {
            shoppingCart = ShoppingCart.newShoppingCart(dto.getUserId());
        }

        // Get product from product service
        ProductDto productDto = this.productsService.getProduct(dto.getProductId());

        // Create item based on product
        Item item = shoppingCart.getItem(dto.getProductId());

        if (item == null) {
            item = this.createItemFrom(productDto, dto.getQuantity(), shoppingCart);
            shoppingCart.addItem(item);
        } else {
            shoppingCart.increaseItemQuantity(dto.getProductId(), Quantity.valueOf(dto.getQuantity()));
        }

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
    @Transactional
    public ShoppingCartDto getShoppingCartByUserId(String userId) {

        ShoppingCart shoppingCart = this.shoppingCartRepository.findShoppingCartByUserId(userId);
        if (shoppingCart == null) return null;

        Set<ItemDto> productsDto = new HashSet<>();
        for (Item item : shoppingCart.getItems()) {
            productsDto.add(ItemDto.builder()
                    .productId(item.getProductId())
                    .price(item.getPrice().getNumber().doubleValue())
                    .quantity(item.getQuantity().value())
                    .build());
        }

        return ShoppingCartDto.builder()
                .shoppingCartId(shoppingCart.getShoppingCartId())
                .userId(shoppingCart.getUserId())
                .totalPrice(shoppingCart.getTotalPrice())
                .totalQuantity(shoppingCart.getTotalQuantity())
                .products(productsDto)
                .build();
    }

    private Item createItemFrom(ProductDto productDto, Integer quantity, ShoppingCart shoppingCart) {
        MonetaryAmount price = Monetary.getDefaultAmountFactory()
                .setCurrency(eur)
                .setNumber(productDto.getPrice())
                .create();

        Item item;
        try {
            item = Item.newItem(productDto.getProductId(), price, shoppingCart);
            item.addQuantity(Quantity.valueOf(quantity));
        } catch (Exception e) {
            return null;
        }

        return item;
    }
}
