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

@Entity
@Table(name = "tb_maoobra")
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class MaoObra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMaoObra;
    //salario desejado pela pessoa
    private double salario;
    //horas que a pessoa deseja trabalhar por dia
    private long horaTrabalho;
}
