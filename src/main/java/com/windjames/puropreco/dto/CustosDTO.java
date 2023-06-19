package com.windjames.puropreco.dto;

import org.springframework.beans.BeanUtils;

import com.windjames.puropreco.entities.Custos;
import com.windjames.puropreco.projection.CustosProjection;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustosDTO {
    
    private long idCusto;
    @NotBlank(message = "O campo Nome do Custo deve ser preenchido")
    private String nomeCusto;
    @NotNull(message = "O campo Valor do Custo deve ser preenchido")
    private double valorCusto;
    @NotBlank(message = "O campo Fixo ou Variavel deve ser preenchido")
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
