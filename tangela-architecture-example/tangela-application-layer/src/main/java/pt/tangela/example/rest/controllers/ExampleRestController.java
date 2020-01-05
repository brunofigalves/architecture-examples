package pt.tangela.example.rest.controllers;

import pt.tangela.example.core.models.Example;
import pt.tangela.example.core.services.ExampleService;
import pt.tangela.example.rest.dtos.ExampleRestRequest;
import pt.tangela.example.rest.mappers.ExampleMapper;
import pt.tangela.example.persistence.repositories.ExampleJpaRepository;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/examples")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExampleRestController {

    @Resource
    private ExampleService service;
    @Resource
    private ExampleJpaRepository repository;

    @GET
    public Response getExample() {
        return Response.ok(service.getHelloWorld()).build();
    }

    @POST
    public Response createExample(ExampleRestRequest request) {
        // Domain service creates instance
        Example createdExample = service.createService(request);

        // Persistence layer returns persisted instance
        pt.tangela.example.persistence.models.Example persistedExample = repository.save(
                ExampleMapper.INSTANCE.toPersistenceObject(createdExample)
        );

        // Convert to DTO and returns response
        return Response.ok(
                ExampleMapper.INSTANCE.toDto(persistedExample)
        ).build();
    }
}
