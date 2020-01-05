package pt.tangela.example.core.services;

import pt.tangela.example.core.models.Example;
import pt.tangela.example.core.dtos.ExampleDto;

public class ExampleService {
    public String getHelloWorld() {
        return "Hello world!";
    }

    public Example createService(ExampleDto dto) {
        Example example = Example.builder()
                .value(dto.getValue())
                .build();

        return example;
    }
}
