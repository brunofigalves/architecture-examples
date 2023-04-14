package com.sample.user.api.rest.controllers;

import com.sample.user.domain.models.dtos.UserDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserRestController {

    @GET
    List<UserDto> getUsers();

    @GET
    @Path("{userId}")
    UserDto getUser(@PathParam("userId") String userId);

    @POST
    UserDto newUser(UserDto dto);
}
