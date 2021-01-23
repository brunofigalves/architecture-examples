package pt.sample.service.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ShoppingCartDto {
    private String shoppingCartId;
    private String userId;
    private Double totalPrice;
    private Integer totalQuantity;
    private Set<AddItemDto> products;
}
