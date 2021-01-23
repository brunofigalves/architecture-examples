package pt.sample.service.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemDto {
    private String productId;
    private Integer quantity;
    private Double price;
}
