package com.example.phonet.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double debit;
    private Double credit;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
