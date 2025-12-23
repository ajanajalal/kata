package ma.carrefour.kata.infrastructure.persistence.mapper;


import ma.carrefour.kata.domain.entity.GroupPurchase;
import ma.carrefour.kata.domain.entity.Participant;
import ma.carrefour.kata.infrastructure.persistence.entity.GroupPurchaseEntity;
import ma.carrefour.kata.infrastructure.persistence.entity.ParticipantEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {ProductEntityMapper.class, CustomerEntityMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface GroupPurchaseEntityMapper {

    @Mapping(target = "participants", source = "participants")
    GroupPurchaseEntity toEntity(GroupPurchase domain);

    @Mapping(target = "participants", source = "participants")
    GroupPurchase toDomain(GroupPurchaseEntity entity);

    List<GroupPurchase> toDomainList(List<GroupPurchaseEntity> entities);

    List<GroupPurchaseEntity> toEntityList(List<GroupPurchase> domains);

    @Mapping(target = "groupPurchase", ignore = true)
    ParticipantEntity toParticipantEntity(Participant domain);

    @Mapping(target = "groupPurchase", ignore = true)
    Participant toParticipantDomain(ParticipantEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(GroupPurchase domain, @MappingTarget GroupPurchaseEntity entity);
}