package com.example.phonet.task.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int age;
    private int itn;

    @OneToOne
    @JoinColumn(name = "balance_id", nullable = false)
    private Balance balance;

    @OneToOne
    @JoinColumn(name = "history_id", nullable = false)
    private History history;
}
