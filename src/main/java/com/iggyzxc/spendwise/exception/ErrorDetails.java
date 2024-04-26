package com.iggyzxc.spendwise.exception;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public record ErrorDetails(LocalDateTime timestamp,
                           String message,
                           String details,
                           String errorCode) {
}
