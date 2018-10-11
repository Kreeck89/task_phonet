package com.example.phonet.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "histories")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double value;
    @Column(name = "type_transaction", nullable = false)
    private Transaction type;
    @Column(name = "from_user", nullable = false)
    private Long from;
    @Column(name = "to_user", nullable = false)
    private Long to;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
