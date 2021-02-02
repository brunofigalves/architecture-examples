package pt.sample.service.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddItemDto {
    private String userId;
    private String productId;
    private Integer quantity;
}
