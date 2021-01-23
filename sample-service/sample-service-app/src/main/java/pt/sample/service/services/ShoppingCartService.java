package pt.sample.service.services;

import pt.sample.service.services.dtos.AddItemDto;
import pt.sample.service.services.dtos.ItemDto;
import pt.sample.service.services.dtos.ShoppingCartDto;

public interface ShoppingCartService {

    ItemDto addItem(AddItemDto dto);

    void removeItem(String productId);

    ShoppingCartDto getShoppingCartByUserId(String userId);

}
