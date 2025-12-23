package ma.carrefour.kata.presentation.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupPurchaseRequest {

    @NotNull(message = "Product ID is required")
    private Long productId;

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Minimum participants is required")
    @Min(value = 2, message = "Minimum participants must be at least 2")
    private Integer minParticipants;

    @NotNull(message = "Maximum participants is required")
    @Min(value = 2, message = "Maximum participants must be at least 2")
    private Integer maxParticipants;

    @NotNull(message = "Expiration deadline is required")
    @Future(message = "Expiration deadline must be in the future")
    private LocalDateTime expirationDeadline;
}