package ma.carrefour.kata.infrastructure.persistence.mapper;

import ma.carrefour.kata.domain.entity.Product;
import ma.carrefour.kata.infrastructure.persistence.entity.ProductEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ProductEntityMapper {

    /**
     * Convert Domain Product to JPA ProductEntity
     */
    ProductEntity toEntity(Product domain);

    /**
     * Convert JPA ProductEntity to Domain Product
     */
    Product toDomain(ProductEntity entity);

    /**
     * Convert list of JPA entities to list of Domain entities
     */
    List<Product> toDomainList(List<ProductEntity> entities);

    /**
     * Convert list of Domain entities to list of JPA entities
     */
    List<ProductEntity> toEntityList(List<Product> domains);

    /**
     * Update existing entity with domain data (for partial updates)
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    void updateEntity(Product domain, @MappingTarget ProductEntity entity);
}