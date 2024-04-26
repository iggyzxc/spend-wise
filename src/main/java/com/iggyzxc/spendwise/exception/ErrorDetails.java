package com.iggyzxc.spendwise.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(
        description = "Error details containing information about an error."
)
public record ErrorDetails(
        @Schema(
                description = "Timestamp indicating when the error occurred."
        )
        LocalDateTime timestamp,
        @Schema(
                description = "A brief message providing information about the error."
        )
        String message,
        @Schema(
                description = "Additional details providing context or further information about the error."
        )
        String details,
        @Schema(
                description = "Error code representing the specific type or category of the error."
        )
        String errorCode) {
}
