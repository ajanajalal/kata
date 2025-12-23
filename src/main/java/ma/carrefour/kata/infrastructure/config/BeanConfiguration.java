package ma.carrefour.kata.infrastructure.config;



import ma.carrefour.kata.domain.repository.CustomerRepository;
import ma.carrefour.kata.domain.repository.GroupPurchaseRepository;
import ma.carrefour.kata.domain.repository.ProductRepository;
import ma.carrefour.kata.infrastructure.persistence.adapter.CustomerPersistenceAdapter;
import ma.carrefour.kata.infrastructure.persistence.adapter.GroupPurchasePersistenceAdapter;
import ma.carrefour.kata.infrastructure.persistence.adapter.ProductPersistenceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public GroupPurchaseRepository groupPurchaseRepository(
            GroupPurchasePersistenceAdapter adapter) {
        return adapter;
    }

    @Bean
    public ProductRepository productRepository(ProductPersistenceAdapter adapter) {
        return adapter;
    }

    @Bean
    public CustomerRepository customerRepository(CustomerPersistenceAdapter adapter) {
        return adapter;
    }
}