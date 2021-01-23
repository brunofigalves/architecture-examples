package pt.sample.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pt.sample.service.controllers.ShoppingCartRestController;
import pt.sample.service.controllers.impl.ShoppingCartControllerImpl;

@Configuration
public class SampleServiceContext {

    @Bean
    public ShoppingCartRestController shoppingCartRestController() {
        return new ShoppingCartControllerImpl();
    }
}
