package com.windjames.puropreco.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_ingredientes")
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class MaoObra {
    //salario desejado pela pessoa
    private double salario;
    //horas que a pessoa deseja trabalhar por dia
    private long horaTrabalho;
    private long horasMes;
    //calcula o custo da hora
    private double valorHora;
    //calcula o custo do minuto
    private double valorMinuto;
}
