package ma.carrefour.kata.application.usecases;


import lombok.RequiredArgsConstructor;
import ma.carrefour.kata.application.dto.CreateGroupPurchaseCommand;
import ma.carrefour.kata.application.dto.GroupPurchaseDTO;
import ma.carrefour.kata.application.mapper.GroupPurchaseMapper;
import ma.carrefour.kata.application.port.input.CreateGroupPurchaseInputPort;
import ma.carrefour.kata.domain.entity.Customer;
import ma.carrefour.kata.domain.entity.GroupPurchase;
import ma.carrefour.kata.domain.entity.Product;
import ma.carrefour.kata.domain.exceptions.ResourceNotFoundException;
import ma.carrefour.kata.domain.repository.CustomerRepository;
import ma.carrefour.kata.domain.repository.GroupPurchaseRepository;
import ma.carrefour.kata.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateGroupPurchaseUseCase implements CreateGroupPurchaseInputPort {

    private final GroupPurchaseRepository groupPurchaseRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final GroupPurchaseMapper mapper;

    @Override
    @Transactional
    public GroupPurchaseDTO execute(CreateGroupPurchaseCommand command) {
        Product product = productRepository.findById(command.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Customer creator = customerRepository.findById(command.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        GroupPurchase groupPurchase = GroupPurchase.create(
                product,
                creator,
                command.getMinParticipants(),
                command.getMaxParticipants(),
                command.getExpirationDeadline()
        );

        GroupPurchase saved = groupPurchaseRepository.save(groupPurchase);

        return mapper.toDTO(saved);
    }
}