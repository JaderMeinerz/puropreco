package com.windjames.puropreco.dto;

import org.springframework.beans.BeanUtils;

import com.windjames.puropreco.entities.MaoObra;

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

}
