package ma.carrefour.kata.domain.entity;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Participant {
    private Long id;
    @OneToOne
    private Customer customer;

    @OneToOne
    private GroupPurchase groupPurchase;
    private LocalDateTime joinedAt;

    public static Participant create(Customer customer, GroupPurchase groupPurchase) {
        return new Participant(
                null,
                customer,
                groupPurchase,
                LocalDateTime.now()
        );
    }
}