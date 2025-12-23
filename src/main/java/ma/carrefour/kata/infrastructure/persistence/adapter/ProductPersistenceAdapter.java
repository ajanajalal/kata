package ma.carrefour.kata.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import ma.carrefour.kata.domain.entity.Product;
import ma.carrefour.kata.domain.repository.ProductRepository;
import ma.carrefour.kata.infrastructure.persistence.mapper.ProductEntityMapper;
import ma.carrefour.kata.infrastructure.persistence.repository.JpaProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProductPersistenceAdapter implements ProductRepository {

    private final JpaProductRepository jpaRepository;
    private final ProductEntityMapper mapper;



    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {

        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
}
