package ma.carrefour.kata.infrastructure.persistence.adapter;

import lombok.RequiredArgsConstructor;
import ma.carrefour.kata.domain.entity.Customer;
import ma.carrefour.kata.domain.repository.CustomerRepository;
import ma.carrefour.kata.infrastructure.persistence.mapper.CustomerEntityMapper;
import ma.carrefour.kata.infrastructure.persistence.repository.JpaCustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerPersistenceAdapter  implements CustomerRepository {

    private final JpaCustomerRepository jpaRepository;
    private final CustomerEntityMapper mapper;



    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> findById(Long id) {

        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }
}
