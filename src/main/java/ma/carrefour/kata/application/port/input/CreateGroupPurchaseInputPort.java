package ma.carrefour.kata.application.port.input;


import ma.carrefour.kata.application.dto.CreateGroupPurchaseCommand;
import ma.carrefour.kata.application.dto.GroupPurchaseDTO;

public interface CreateGroupPurchaseInputPort {
    GroupPurchaseDTO execute(CreateGroupPurchaseCommand command);
}