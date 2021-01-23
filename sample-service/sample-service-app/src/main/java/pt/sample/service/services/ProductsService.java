package pt.sample.service.services;

import pt.sample.service.services.dtos.ProductDto;

public interface ProductsService {

    ProductDto getProduct(String productId);

}
