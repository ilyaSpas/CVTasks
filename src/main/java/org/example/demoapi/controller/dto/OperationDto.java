package org.example.demoapi.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {

    @Length(message = "Wrong size", min = 36, max = 36)
    @NotEmpty(message = "Wallet id should not be empty")
    private String walletId;

    @NotEmpty(message = "Operation type should not be empty")
    private String operationType;

    @Pattern(regexp = "[-0-9]{1,12}+$",
            message = "Use only numbers")
    @NotEmpty(message = "Amount should not be empty")
    private String amount;
}
