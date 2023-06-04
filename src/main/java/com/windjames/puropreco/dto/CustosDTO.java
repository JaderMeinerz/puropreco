package com.windjames.puropreco.dto;

import org.springframework.beans.BeanUtils;

import com.windjames.puropreco.entities.Custos;
import com.windjames.puropreco.projection.CustosProjection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustosDTO {
    
    private long idCusto;
    private String nomeCusto;
    private double valorCusto;
    private String fixoVariavel;

    public CustosDTO(Custos entity){
        BeanUtils.copyProperties(entity, this);
    }

    public CustosDTO(CustosProjection projection){
        idCusto = projection.getIdCustos();
        nomeCusto = projection.getNomeCusto();
        valorCusto = projection.getValorCusto();
        fixoVariavel = projection.getFixoVariavel();
    }
}
