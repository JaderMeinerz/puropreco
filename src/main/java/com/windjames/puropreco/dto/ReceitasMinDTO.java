package com.windjames.puropreco.dto;

import org.springframework.beans.BeanUtils;

import com.windjames.puropreco.entities.Receitas;
import com.windjames.puropreco.projection.ReceitasMinProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReceitasMinDTO {
    
    private long idReceitas;
    private String nomeReceita;
    private long tempoPreparo;

    public ReceitasMinDTO(Receitas entity){
        BeanUtils.copyProperties(entity, this);
    }

    public ReceitasMinDTO(ReceitasMinProjection projection){
        idReceitas = projection.getIdReceitas();
        nomeReceita = projection.getNomeReceita();
        tempoPreparo = projection.getTempoPreparo();

    }
}
