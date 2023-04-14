package pt.tangela.example.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pt.tangela.example.core.dtos.ExampleDto;
import pt.tangela.example.core.models.Example;

@Mapper
public interface ExampleMapper {
    ExampleMapper INSTANCE = Mappers.getMapper(ExampleMapper.class);

    Example toDomainObject(pt.tangela.example.persistence.models.Example persistenceObject);

    pt.tangela.example.persistence.models.Example toPersistenceObject(Example model);

    ExampleDto toDto(pt.tangela.example.persistence.models.Example model);

}
