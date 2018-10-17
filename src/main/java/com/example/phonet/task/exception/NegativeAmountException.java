package com.example.phonet.task.exception;

import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
public class NegativeAmountException extends IOException {

    public NegativeAmountException(String message) {
        super(message);
    }
}
