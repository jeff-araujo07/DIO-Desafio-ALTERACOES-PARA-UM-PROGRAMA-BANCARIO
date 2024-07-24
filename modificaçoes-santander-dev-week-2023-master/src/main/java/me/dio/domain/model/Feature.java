package me.dio.domain.model;

import jakarta.persistence.Entity;

@Entity(name = "tb_feature")
public class Feature extends BaseItem {

    // Construtor padrão
    public Feature() {
        super();
    }

    // Construtor com parâmetros para inicializar os campos herdados
    public Feature(String icon, String description) {
        super();
        setIcon(icon);
        setDescription(description);
    }

    // Outros métodos específicos para a classe Feature podem ser adicionados aqui
}

