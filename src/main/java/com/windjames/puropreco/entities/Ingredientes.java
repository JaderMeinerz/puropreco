package com.windjames.puropreco.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "tb_ingredientes")
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Ingredientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idIngredientes;
    private String nome;
    private long medida;
    private String unidadeMedida;
    private double preco;
    
}
