package com.sample.user;

import com.sample.user.api.controllers.impl.UserControllerImpl;
import com.sample.user.api.rest.controllers.UserRestController;
import com.sample.user.domain.services.UserService;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@Dependent
public final class RestApiConfig {

    @Produces
    public UserRestController userRestController(UserService userService) {
        return new UserControllerImpl(userService);
    }
}
