package me.dio.domain.model;

import jakarta.persistence.Entity;

@Entity(name = "tb_news")
public class News extends BaseItem {

    // Construtor padrão
    public News() {
        super();
    }

    // Construtor com parâmetros para inicializar os campos herdados
    public News(String icon, String description) {
        super();
        setIcon(icon);
        setDescription(description);
    }

    // Outros métodos específicos para a classe News podem ser adicionados aqui
}
