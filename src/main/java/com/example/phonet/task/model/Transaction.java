package com.example.phonet.task.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction extends Model {

    private static final long serialVersionUID = -9029071900057063674L;

    private LocalDate date;
    private BigDecimal value;
    @Column(name = "from_user")
    private Long from;
    @Column(name = "to_user")
    private Long to;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    public Transaction() {
        super();
    }

    public Transaction(Long id) {
        super(id);
    }

    @NotNull(message = "Transaction date is can`t be empty.")
    @Past
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @NotNull(message = "Enter value for transaction.")
    @Min(1)
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @NotNull(message = "Enter the Client who will make the transfer.")
    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    @NotNull(message = "Enter the Client who will give the transfer.")
    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
