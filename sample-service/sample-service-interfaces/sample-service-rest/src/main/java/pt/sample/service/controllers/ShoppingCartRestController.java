package pt.sample.service.controllers;

import pt.sample.service.services.dtos.AddItemDto;
import pt.sample.service.services.dtos.ItemDto;
import pt.sample.service.services.dtos.ShoppingCartDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/shopping-cart")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface ShoppingCartRestController {

    @POST
    @Path("/add-item")
    ItemDto addItem(AddItemDto dto);

    @POST()
    @Path("/remove-item")
    void removeItem(String productId);

    @GET
    ShoppingCartDto getShoppingCart(AddItemDto dto);
}
