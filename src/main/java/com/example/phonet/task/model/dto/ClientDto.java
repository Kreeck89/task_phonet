package com.example.phonet.task.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClientDto {
    private Long id;
    private String name;
    private String surname;
    private Double balance;
    private Double transactionValue;
    private Long toClientId;
    private LocalDate date;

}
