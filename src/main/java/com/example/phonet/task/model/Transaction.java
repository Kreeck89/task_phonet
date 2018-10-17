package com.example.phonet.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double value;
    @Column(name = "from_user", nullable = false)
    private Long from;
    @Column(name = "to_user", nullable = false)
    private Long to;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
