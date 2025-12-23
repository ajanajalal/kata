package ma.carrefour.kata.infrastructure.persistence.repository;



import ma.carrefour.kata.domain.enums.GroupPurchaseStatus;
import ma.carrefour.kata.infrastructure.persistence.entity.GroupPurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaGroupPurchaseRepository extends JpaRepository<GroupPurchaseEntity, Long> {

    List<GroupPurchaseEntity> findByStatus(GroupPurchaseStatus status);

    @Query("SELECT gp FROM GroupPurchaseEntity gp " +
            "LEFT JOIN FETCH gp.participants p " +
            "LEFT JOIN FETCH p.customer " +
            "WHERE gp.status = :status")
    List<GroupPurchaseEntity> findByStatusWithParticipants(GroupPurchaseStatus status);

    @Query("SELECT gp FROM GroupPurchaseEntity gp " +
            "LEFT JOIN FETCH gp.product " +
            "LEFT JOIN FETCH gp.creator " +
            "LEFT JOIN FETCH gp.participants p " +
            "LEFT JOIN FETCH p.customer " +
            "WHERE gp.id = :id")
    GroupPurchaseEntity findByIdWithDetails(Long id);
}