package pt.sample.service.services.dtos;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private String productId;
    private Double price;
}
