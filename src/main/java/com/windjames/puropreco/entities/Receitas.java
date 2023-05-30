package com.windjames.puropreco.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_receitas")
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class Receitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReceitas;
    private String ingrediente;
    private long quantidade;
    //rendimento em gramas da receita
    private long rendimento;
    private double custoTotal;
    //peso da unidade
    private long pesoUnidade;
    private double custoUnidade;
    private long tempoPreparo;
}
