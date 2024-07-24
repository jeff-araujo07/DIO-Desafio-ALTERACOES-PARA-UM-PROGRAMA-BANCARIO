package me.dio.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String number;

    @Column(nullable = false)
    private String agency;

    @Column(precision = 13, scale = 2, nullable = false)
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    // Construtor padrão
    public Account() {
    }

    // Construtor com todos os campos
    public Account(String number, String agency, BigDecimal balance, BigDecimal limit) {
        this.number = number;
        this.agency = agency;
        this.balance = balance;
        this.limit = limit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter que usa Optional para indicar possibilidade de valor nulo
    public Optional<String> getNumber() {
        return Optional.ofNullable(number);
    }

    // Validação para garantir que o número da conta não seja nulo ou vazio
    public void setNumber(String number) {
        if (number != null && !number.isEmpty()) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("O número da conta não pode ser nulo ou vazio");
        }
    }

    // Getter que usa Optional para indicar possibilidade de valor nulo
    public Optional<String> getAgency() {
        return Optional.ofNullable(agency);
    }

    // Validação para garantir que a agência não seja nula ou vazia
    public void setAgency(String agency) {
        if (agency != null && !agency.isEmpty()) {
            this.agency = agency;
        } else {
            throw new IllegalArgumentException("A agência não pode ser nula ou vazia");
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    // Validação para garantir que o saldo não seja nulo ou negativo
    public void setBalance(BigDecimal balance) {
        if (balance != null && balance.compareTo(BigDecimal.ZERO) >= 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("O saldo não pode ser nulo ou negativo");
        }
    }

    // Getter que usa Optional para indicar possibilidade de valor nulo
    public Optional<BigDecimal> getLimit() {
        return Optional.ofNullable(limit);
    }

    // Validação para garantir que o limite não seja nulo ou negativo
    public void setLimit(BigDecimal limit) {
        if (limit != null && limit.compareTo(BigDecimal.ZERO) >= 0) {
            this.limit = limit;
        } else {
            throw new IllegalArgumentException("O limite não pode ser nulo ou negativo");
        }
    }
}
