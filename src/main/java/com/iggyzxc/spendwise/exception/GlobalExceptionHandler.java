package com.iggyzxc.spendwise.service.impl;

import com.iggyzxc.spendwise.exception.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ErrorDetails> ResourceNotFound
}
