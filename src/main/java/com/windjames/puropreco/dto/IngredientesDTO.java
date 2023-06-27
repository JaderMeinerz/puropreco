package com.windjames.puropreco.dto;

import org.springframework.beans.BeanUtils;

import com.windjames.puropreco.entities.Ingredientes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientesDTO {

    private long idIngredientes;
    @NotBlank(message = "O campo Nome do Ingrediente deve ser preenchido.")
    private String nome;
    @NotNull(message = "O campo Quantidade na Embalagem deve ser preenchido.")
    private long medida;
    @NotBlank(message = "O campo Unidade de Medida deve ser preenchido.")
    private String unidadeMedida;
    @NotNull(message = "O campo Preço do Ingrediente deve ser preenchido.")
    private double preco;

    public IngredientesDTO(Ingredientes entity){
        BeanUtils.copyProperties(entity, this);
    }
}
