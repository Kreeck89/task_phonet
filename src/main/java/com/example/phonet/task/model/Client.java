package com.example.phonet.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private Integer age;
    private Integer itn;
    private Double balance;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Transaction> transactions;
}
