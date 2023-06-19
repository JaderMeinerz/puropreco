package com.windjames.puropreco.dto;

import org.springframework.beans.BeanUtils;

import com.windjames.puropreco.entities.MaoObra;
import com.windjames.puropreco.projection.MaoObraProjection;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaoObraDTO {
    
    private long idMaoObra;
    @NotNull(message = "O campo Salário Desejado deve ser preenchido")
    private double salario;
    @NotNull(message = "O Campo Horas de Trabalho deve ser preenchido")
    private long horaTrabalho;

    public MaoObraDTO(MaoObra entity){
        BeanUtils.copyProperties(entity, this);
    }

    public MaoObraDTO(MaoObraProjection projection){
        idMaoObra = projection.getIdMaoObra();
        salario = projection.getSalario();
        horaTrabalho = projection.getHoraTrabalho();
    }
    
}
