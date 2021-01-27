package pt.sample.service.controllers;

import pt.sample.service.services.dtos.AddItemDto;
import pt.sample.service.services.dtos.ItemDto;
import pt.sample.service.services.dtos.ShoppingCartDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/shopping-cart")
@Produces(MediaType.APPLICATION_JSON)
public interface ShoppingCartRestController {

    @POST
    @Path("/add-item")
    @Consumes(MediaType.APPLICATION_JSON)
    ItemDto addItem(AddItemDto dto) throws Exception;

    @POST
    @Path("/remove-item")
    @Consumes(MediaType.APPLICATION_JSON)
    void removeItem(String productId);

    @GET
    ShoppingCartDto getShoppingCart(@QueryParam("userId") String userId);
}
