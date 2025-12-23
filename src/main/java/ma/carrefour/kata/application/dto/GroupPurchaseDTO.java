package ma.carrefour.kata.application.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.carrefour.kata.domain.enums.GroupPurchaseStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupPurchaseDTO {
    private Long id;
    private String productName;
    private BigDecimal groupPrice;
    private String creatorName;
    private Integer minParticipants;
    private Integer maxParticipants;
    private Integer currentParticipants;
    private LocalDateTime expirationDeadline;
    private GroupPurchaseStatus status;
    private List<ParticipantDTO> participants;
    private LocalDateTime createdAt;
}