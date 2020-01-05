package pt.tangela.example.rest.mappers;

import javax.annotation.Generated;
import pt.tangela.example.core.dtos.ExampleDto;
import pt.tangela.example.core.dtos.ExampleDto.ExampleDtoBuilder;
import pt.tangela.example.core.models.Example.ExampleBuilder;
import pt.tangela.example.persistence.models.Example;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-01-05T03:52:05+0000",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.5 (JetBrains s.r.o)"
)
public class ExampleMapperImpl implements ExampleMapper {

    @Override
    public pt.tangela.example.core.models.Example toDomainObject(Example persistenceObject) {
        if ( persistenceObject == null ) {
            return null;
        }

        ExampleBuilder example = pt.tangela.example.core.models.Example.builder();

        example.value( persistenceObject.getValue() );

        return example.build();
    }

    @Override
    public Example toPersistenceObject(pt.tangela.example.core.models.Example model) {
        if ( model == null ) {
            return null;
        }

        Example example = new Example();

        example.setValue( model.getValue() );

        return example;
    }

    @Override
    public ExampleDto toDto(Example model) {
        if ( model == null ) {
            return null;
        }

        ExampleDtoBuilder exampleDto = ExampleDto.builder();

        exampleDto.value( model.getValue() );

        return exampleDto.build();
    }
}
