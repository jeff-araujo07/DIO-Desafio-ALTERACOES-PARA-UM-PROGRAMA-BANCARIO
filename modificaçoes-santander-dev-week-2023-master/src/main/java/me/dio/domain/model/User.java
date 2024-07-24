package me.dio.domain.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<News> news;

    // Construtor padrão
    public User() {
    }

    // Getter para o campo 'id'
    public Long getId() {
        return id;
    }

    // Setter para o campo 'id'
    public void setId(Long id) {
        this.id = id;
    }

    // Getter usando Optional para o campo 'name'
    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    // Setter para o campo 'name', com validação básica
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio");
        }
    }

    // Getter para o campo 'account'
    public Optional<Account> getAccount() {
        return Optional.ofNullable(account);
    }

    // Setter para o campo 'account'
    public void setAccount(Account account) {
        this.account = account;
    }

    // Getter para o campo 'card'
    public Optional<Card> getCard() {
        return Optional.ofNullable(card);
    }

    // Setter para o campo 'card'
    public void setCard(Card card) {
        this.card = card;
    }

    // Getter para a lista 'features'
    public List<Feature> getFeatures() {
        return features;
    }

    // Setter para a lista 'features'
    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    // Getter para a lista 'news'
    public List<News> getNews() {
        return news;
    }

    // Setter para a lista 'news'
    public void setNews(List<News> news) {
        this.news = news;
    }
}

