package ma.carrefour.kata.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import ma.carrefour.kata.domain.enums.GroupPurchaseStatus;
import ma.carrefour.kata.domain.exceptions.GroupPurchaseException;
import ma.carrefour.kata.domain.exceptions.GroupPurchaseExpiredException;
import ma.carrefour.kata.domain.exceptions.GroupPurchaseFullException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class GroupPurchase {
    private Long id;
    private Product product;
    private Customer creator;
    private Integer minParticipants;
    private Integer maxParticipants;
    private LocalDateTime expirationDeadline;
    private GroupPurchaseStatus status;
    private List<Participant> participants;
    private LocalDateTime createdAt;

    public static GroupPurchase create(Product product, Customer creator,
                                       Integer minParticipants, Integer maxParticipants,
                                       LocalDateTime expirationDeadline) {
        validateParameters(minParticipants, maxParticipants, expirationDeadline);

        GroupPurchase groupPurchase = new GroupPurchase(
                null,
                product,
                creator,
                minParticipants,
                maxParticipants,
                expirationDeadline,
                GroupPurchaseStatus.ACTIVE,
                new ArrayList<>(),
                LocalDateTime.now()
        );

        groupPurchase.addParticipant(creator);

        return groupPurchase;
    }

    public void addParticipant(Customer customer) {
        validateCanJoin();
        validateNotAlreadyParticipant(customer);

        Participant participant = Participant.create(customer, this);
        participants.add(participant);

        updateStatus();
    }


    private void updateStatus() {
        if (participants.size() >= maxParticipants) {
            this.status = GroupPurchaseStatus.FULL;
        }
    }

    private void validateNotAlreadyParticipant(Customer customer) {
        boolean alreadyJoined = participants.stream()
                .anyMatch(p -> p.getCustomer().getId().equals(customer.getId()));

        if (alreadyJoined) {
            throw new GroupPurchaseException("Customer already joined");
        }
    }

    private void validateCanJoin() {
        if (status == GroupPurchaseStatus.CLOSED) {
            throw new GroupPurchaseException("Group purchase is closed");
        }

        if (status == GroupPurchaseStatus.FULL) {
            throw new GroupPurchaseFullException("Group purchase is full");
        }

        if (LocalDateTime.now().isAfter(expirationDeadline)) {
            throw new GroupPurchaseExpiredException("Group purchase has expired");
        }

        if (participants.size() >= maxParticipants) {
            throw new GroupPurchaseFullException("Maximum participants reached");
        }
    }



    private static void validateParameters(Integer minParticipants,
                                           Integer maxParticipants,
                                           LocalDateTime expirationDeadline) {
        if (minParticipants < 2) {
            throw new GroupPurchaseException("Minimum participants must be at least 2");
        }

        if (maxParticipants < minParticipants) {
            throw new GroupPurchaseException(
                    "Maximum participants cannot be less than minimum"
            );
        }

        if (expirationDeadline.isBefore(LocalDateTime.now())) {
            throw new GroupPurchaseException("Expiration deadline must be in the future");
        }
    }


}
