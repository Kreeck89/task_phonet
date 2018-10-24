package com.example.phonet.task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends Model {

    private static final long serialVersionUID = -273767854917356731L;

    private String email;
    private String password;
    private String name;
    private String surname;
    private LocalDate age;
    private Integer itn;
    private BigDecimal balance;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Transaction> transactions;

    public Client() {
        super();
    }

    public Client(Long id) {
        super(id);
    }

    @Email(message = "Enter a correct email")
    @NotNull(message = "Email must not be null")
    @Size(min = 5, max = 254)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "Enter the password")
    @Max(value = 254, message = "Your password must be shortly")
    @Min(value = 5, message = "Your password so short")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "Enter your name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Enter your surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @NotNull(message = "Enter you birthday")
    @Past
    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    @NotNull(message = "Enter you ITN for registration in service.")
    public Integer getItn() {
        return itn;
    }

    public void setItn(Integer itn) {
        this.itn = itn;
    }

    @NotEmpty
    @Min(value = -1000, message = "Your credit limit not over 1000uah.")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @NotNull(message = "You must have list with transactions.")
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}


