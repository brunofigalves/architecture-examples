package com.sample.user;

import com.sample.user.api.controllers.UserController;
import com.sample.user.api.rest.controllers.UserRestController;
import com.sample.user.api.rest.controllers.impl.UserRestControllerImpl;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@Dependent
public final class RestApiConfig {

    @Produces
    public UserRestController userRestController(UserController userController) {
        return new UserRestControllerImpl(userController);
    }
}
