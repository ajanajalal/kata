package ma.carrefour.kata.domain.repository;

import ma.carrefour.kata.domain.entity.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> findById(Long id);
}
