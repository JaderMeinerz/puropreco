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

@Table(name = "tb_receitas")
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Entity
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
