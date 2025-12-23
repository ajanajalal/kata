package ma.carrefour.kata.domain.repository;

import ma.carrefour.kata.domain.entity.GroupPurchase;
import ma.carrefour.kata.domain.enums.GroupPurchaseStatus;

import java.util.List;
import java.util.Optional;

public interface GroupPurchaseRepository {
    GroupPurchase save(GroupPurchase groupPurchase);
}
