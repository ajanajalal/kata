package ma.carrefour.kata.application.mapper;


import ma.carrefour.kata.application.dto.GroupPurchaseDTO;
import ma.carrefour.kata.application.dto.ParticipantDTO;
import ma.carrefour.kata.domain.entity.GroupPurchase;
import ma.carrefour.kata.domain.entity.Participant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupPurchaseMapper {

    public GroupPurchaseDTO toDTO(GroupPurchase groupPurchase) {
        if (groupPurchase == null) {
            return null;
        }

        return GroupPurchaseDTO.builder()
                .id(groupPurchase.getId())
                .productName(groupPurchase.getProduct().getName())
                .groupPrice(groupPurchase.getProduct().getGroupPrice())
                .creatorName(groupPurchase.getCreator().getName())
                .minParticipants(groupPurchase.getMinParticipants())
                .maxParticipants(groupPurchase.getMaxParticipants())
                .expirationDeadline(groupPurchase.getExpirationDeadline())
                .status(groupPurchase.getStatus())
                .createdAt(groupPurchase.getCreatedAt())
                .build();
    }

    public List<GroupPurchaseDTO> toDTOList(List<GroupPurchase> groupPurchases) {
        if (groupPurchases == null) {
            return null;
        }

        return groupPurchases.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ParticipantDTO toParticipantDTO(Participant participant) {
        if (participant == null) {
            return null;
        }

        return ParticipantDTO.builder()
                .id(participant.getId())
                .customerId(participant.getCustomer().getId())
                .customerName(participant.getCustomer().getName())
                .customerEmail(participant.getCustomer().getEmail())
                .joinedAt(participant.getJoinedAt())
                .build();
    }

    public List<ParticipantDTO> toParticipantDTOList(List<Participant> participants) {
        if (participants == null) {
            return null;
        }

        return participants.stream()
                .map(this::toParticipantDTO)
                .collect(Collectors.toList());
    }
}