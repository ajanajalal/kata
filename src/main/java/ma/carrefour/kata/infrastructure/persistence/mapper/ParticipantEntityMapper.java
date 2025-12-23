package ma.carrefour.kata.infrastructure.persistence.mapper;

import ma.carrefour.kata.domain.entity.Participant;
import ma.carrefour.kata.infrastructure.persistence.entity.ParticipantEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {CustomerEntityMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface ParticipantEntityMapper {

    /**
     * Convert Domain Participant to JPA ParticipantEntity
     * Ignore groupPurchase to avoid circular reference (it's set separately)
     */
    @Mapping(target = "groupPurchase", ignore = true)
    ParticipantEntity toEntity(Participant domain);

    /**
     * Convert JPA ParticipantEntity to Domain Participant
     * MapStruct will automatically map all matching fields
     */
    Participant toDomain(ParticipantEntity entity);

    /**
     * Convert list of JPA entities to list of Domain entities
     */
    List<Participant> toDomainList(List<ParticipantEntity> entities);

    /**
     * Convert list of Domain entities to list of JPA entities
     */
    List<ParticipantEntity> toEntityList(List<Participant> domains);

    /**
     * Update existing entity with domain data
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "groupPurchase", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "joinedAt", ignore = true)
    void updateEntity(Participant domain, @MappingTarget ParticipantEntity entity);
}