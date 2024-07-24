package me.dio.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.Optional;

@MappedSuperclass
public abstract class BaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;
    private String description;

    // Getter para o campo 'id'
    public Long getId() {
        return id;
    }

    // Setter para o campo 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter usando Optional para o campo 'icon', pode ser nulo
    public Optional<String> getIcon() {
        return Optional.ofNullable(icon);
    }

    // Setter para o campo 'icon', com validação básica
    public void setIcon(String icon) {
        if (icon != null && !icon.isEmpty()) {
            this.icon = icon;
        } else {
            throw new IllegalArgumentException("Ícone não pode ser nulo ou vazio");
        }
    }

    // Getter usando Optional para o campo 'description', pode ser nulo
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    // Setter para o campo 'description', com validação básica
    public void setDescription(String description) {
        if (description != null && !description.isEmpty()) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Descrição não pode ser nula ou vazia");
        }
    }
}
