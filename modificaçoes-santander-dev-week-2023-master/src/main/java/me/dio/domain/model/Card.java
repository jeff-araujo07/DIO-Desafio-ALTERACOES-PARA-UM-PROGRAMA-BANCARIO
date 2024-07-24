package me.dio.domain.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String number;

    @Column(name = "available_limit", precision = 13, scale = 2, nullable = false)
    private BigDecimal limit;

    // Construtor padrão
    public Card() {
    }

    // Getter para o campo 'id'
    public Long getId() {
        return id;
    }

    // Setter para o campo 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter usando Optional para o campo 'number', pode ser nulo
    public Optional<String> getNumber() {
        return Optional.ofNullable(number);
    }

    // Setter para o campo 'number', com validação básica
    public void setNumber(String number) {
        if (number != null && !number.isEmpty()) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("O número do cartão não pode ser nulo ou vazio");
        }
    }

    // Getter para o campo 'limit'
    public BigDecimal getLimit() {
        return limit;
    }

    // Setter para o campo 'limit', com validação básica
    public void setLimit(BigDecimal limit) {
        if (limit != null && limit.compareTo(BigDecimal.ZERO) >= 0) {
            this.limit = limit;
        } else {
            throw new IllegalArgumentException("O limite não pode ser nulo ou negativo");
        }
    }
}

