package ma.carrefour.kata.infrastructure.persistence.mapper;


import ma.carrefour.kata.domain.entity.Customer;
import ma.carrefour.kata.infrastructure.persistence.entity.CustomerEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CustomerEntityMapper {
    Customer toDomain(CustomerEntity entity);
}