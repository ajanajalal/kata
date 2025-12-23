package ma.carrefour.kata.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupPurchaseCommand {
    private Long productId;
    private Long customerId;
    private Integer minParticipants;
    private Integer maxParticipants;
    private LocalDateTime expirationDeadline;
}