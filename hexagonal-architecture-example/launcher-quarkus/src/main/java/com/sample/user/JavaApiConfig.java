package com.sample.user;

import com.sample.user.api.controllers.UserController;
import com.sample.user.api.controllers.impl.UserControllerImpl;
import com.sample.user.domain.services.UserService;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@Dependent
public class JavaApiConfig {

    @Produces
    public UserController userController(UserService userService) {
        return new UserControllerImpl(userService);
    }
}
