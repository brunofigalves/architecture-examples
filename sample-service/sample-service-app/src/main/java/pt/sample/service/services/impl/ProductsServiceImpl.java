package pt.sample.service.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import pt.digglet.integration.NestJsTcpClient;
import pt.sample.service.services.ProductsService;
import pt.sample.service.services.dtos.GetProductDto;
import pt.sample.service.services.dtos.ProductDto;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductsServiceImpl implements ProductsService {

    @Resource
    private NestJsTcpClient nestJsClient;

    public ProductDto getProduct(String productId) {
        ProductDto dto = null;
        GetProductDto getProductDto = GetProductDto.builder().productId(productId).build();

        try {
            dto = this.nestJsClient.request("products/getProduct", getProductDto.getProductId(), ProductDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return dto;
    }
}
