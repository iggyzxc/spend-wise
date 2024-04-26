package com.iggyzxc.spendwise.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(
        description = "Expense DTO used to transfer data between the client and server."
)
public record ExpenseDTO(
        @Schema(
                description = "Unique identifier for the expense."
        )
        Long id,

        @Schema(
                description = "Amount of the expense."
        )
         BigDecimal amount,

        @Schema(
                description = "Date of the expense."
        )
         LocalDate expenseDate,

        @Schema(
                description = "Expense category."
        )
         CategoryDTO categoryDTO) {
}
