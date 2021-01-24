package pt.sample.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import pt.digglet.integration.NestJsTcpClient;
import pt.sample.service.controllers.ShoppingCartRestController;
import pt.sample.service.controllers.impl.ShoppingCartControllerImpl;
import pt.sample.service.services.ProductsService;
import pt.sample.service.services.ShoppingCartService;
import pt.sample.service.services.impl.ProductsServiceImpl;
import pt.sample.service.services.impl.ShoppingCartServiceImpl;

@Configuration
public class SampleServiceContext {

    @Bean
    public ShoppingCartRestController shoppingCartRestController() {
        return new ShoppingCartControllerImpl();
    }

    @Bean
    public ShoppingCartService shoppingCartService() {
        return new ShoppingCartServiceImpl();
    }

    @Bean
    public ProductsService productsService() {
        return new ProductsServiceImpl();
    }

    @Bean
    @Lazy
    public NestJsTcpClient nestJsTcpClient(){
       return new NestJsTcpClient("localhost", 60260);
    }

}
