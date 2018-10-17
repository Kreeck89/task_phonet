package com.example.phonet.task.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TransactionDto {

    private LocalDate date;
    private Double value;
    private Long from;
    private Long to;
}
