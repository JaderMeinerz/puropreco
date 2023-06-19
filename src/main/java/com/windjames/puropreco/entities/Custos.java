package com.windjames.puropreco.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "tb_custos")
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Custos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCusto;
    
    private String nomeCusto;
    private double valorCusto;
    private String fixoVariavel;
}
