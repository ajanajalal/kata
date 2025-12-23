package ma.carrefour.kata.presentation.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.carrefour.kata.application.dto.CreateGroupPurchaseCommand;
import ma.carrefour.kata.application.dto.GroupPurchaseDTO;
import ma.carrefour.kata.application.port.input.CreateGroupPurchaseInputPort;
import ma.carrefour.kata.presentation.dto.CreateGroupPurchaseRequest;
import ma.carrefour.kata.presentation.dto.response.ApiResponse;
import ma.carrefour.kata.presentation.mapper.GroupPurchaseRestMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/group-purchases")
@RequiredArgsConstructor
public class GroupPurchaseController {

    private final CreateGroupPurchaseInputPort createGroupPurchaseInputPort;
    private final GroupPurchaseRestMapper restMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<GroupPurchaseDTO>> createGroupPurchase(
            @Valid @RequestBody CreateGroupPurchaseRequest request) {

        CreateGroupPurchaseCommand command = restMapper.toCommand(request);
        GroupPurchaseDTO result = createGroupPurchaseInputPort.execute(command);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(result, "Group purchase created successfully"));
    }


}