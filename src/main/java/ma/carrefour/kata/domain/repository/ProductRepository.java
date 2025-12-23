package ma.carrefour.kata.domain.repository;

import ma.carrefour.kata.domain.entity.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);

}
