package ma.carrefour.kata.presentation.mapper;

import ma.carrefour.kata.application.dto.CreateGroupPurchaseCommand;
import ma.carrefour.kata.presentation.dto.CreateGroupPurchaseRequest;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface GroupPurchaseRestMapper {
    CreateGroupPurchaseCommand toCommand(CreateGroupPurchaseRequest request);
}