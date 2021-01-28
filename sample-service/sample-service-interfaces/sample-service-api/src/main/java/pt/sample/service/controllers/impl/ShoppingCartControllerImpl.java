package pt.sample.service.controllers.impl;

import pt.sample.service.controllers.ShoppingCartRestController;
import pt.sample.service.services.ShoppingCartService;
import pt.sample.service.services.dtos.AddItemDto;
import pt.sample.service.services.dtos.ItemDto;
import pt.sample.service.services.dtos.ShoppingCartDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ShoppingCartControllerImpl implements ShoppingCartRestController {

    @Inject
    ShoppingCartService shoppingCartService;

    @Override
    public ItemDto addItem(AddItemDto dto) throws Exception {
        return shoppingCartService.addItem(dto);
    }

    @Override
    public void removeItem(String productId) {

    }

    @Override
    public ShoppingCartDto getShoppingCart(String userId) {
        return shoppingCartService.getShoppingCartByUserId(userId);
    }
}
