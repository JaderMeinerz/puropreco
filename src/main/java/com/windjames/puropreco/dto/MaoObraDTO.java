package com.windjames.puropreco.dto;

import org.springframework.beans.BeanUtils;

import com.windjames.puropreco.entities.MaoObra;
import com.windjames.puropreco.projection.MaoObraProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaoObraDTO {
    
    private long idMaoObra;
    private double salario;
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
