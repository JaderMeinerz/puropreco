package com.windjames.puropreco.dto;

import org.springframework.beans.BeanUtils;

import com.windjames.puropreco.entities.Receitas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReceitasDTO {
    
    private long idReceitas;
    @NotBlank(message = "O campo Nome da Receita deve ser preenchido.")
    private String nomeReceita;
    @NotNull(message = "O campo Rendimento deve ser preenchido.")
    private long rendimento;
    @NotNull(message = "O campo Peso da Unidade deve ser preenchido.")
    private long pesoUnidade;
    @NotNull(message = "O campo Tempo de Preparo deve ser preenchido.")
    private long tempoPreparo;

    public ReceitasDTO(Receitas entity){
        BeanUtils.copyProperties(entity, this);
    }

}
