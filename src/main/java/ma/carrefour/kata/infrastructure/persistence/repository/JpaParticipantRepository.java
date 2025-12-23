package ma.carrefour.kata.infrastructure.persistence.repository;


import ma.carrefour.kata.infrastructure.persistence.entity.ParticipantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaParticipantRepository extends JpaRepository<ParticipantEntity, Long> {

    List<ParticipantEntity> findByGroupPurchaseId(Long groupPurchaseId);

    List<ParticipantEntity> findByCustomerId(Long customerId);

    boolean existsByGroupPurchaseIdAndCustomerId(Long groupPurchaseId, Long customerId);
}