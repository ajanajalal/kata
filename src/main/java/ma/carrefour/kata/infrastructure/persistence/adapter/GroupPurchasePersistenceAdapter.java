package ma.carrefour.kata.infrastructure.persistence.adapter;


import lombok.RequiredArgsConstructor;
import ma.carrefour.kata.domain.entity.GroupPurchase;
import ma.carrefour.kata.domain.enums.GroupPurchaseStatus;
import ma.carrefour.kata.domain.repository.GroupPurchaseRepository;
import ma.carrefour.kata.infrastructure.persistence.entity.GroupPurchaseEntity;
import ma.carrefour.kata.infrastructure.persistence.mapper.GroupPurchaseEntityMapper;
import ma.carrefour.kata.infrastructure.persistence.repository.JpaGroupPurchaseRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GroupPurchasePersistenceAdapter implements GroupPurchaseRepository {

    private final JpaGroupPurchaseRepository jpaRepository;
    private final GroupPurchaseEntityMapper mapper;

    @Override
    public GroupPurchase save(GroupPurchase groupPurchase) {
        GroupPurchaseEntity entity = mapper.toEntity(groupPurchase);
        GroupPurchaseEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

}