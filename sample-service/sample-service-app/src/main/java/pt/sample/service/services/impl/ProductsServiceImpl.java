package pt.sample.service.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import pt.digglet.integration.NestJsTcpClient;
import pt.digglet.integration.request.Pattern;
import pt.sample.service.services.ProductsService;
import pt.sample.service.services.dtos.GetProductDto;
import pt.sample.service.services.dtos.ProductDto;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductsServiceImpl implements ProductsService {

    private NestJsTcpClient nestJsClient = new NestJsTcpClient("localhost", 60260);

    public ProductDto getProduct(String productId) {
        Pattern pattern = this.nestJsClient.createMessagePattern("products/getAllProducts");
        ProductDto dto = null;
        GetProductDto getProductDto = GetProductDto.builder().productId(productId).build();

        try {
            dto = this.nestJsClient.request(getProductDto, pattern, ProductDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return dto;
    }

}
