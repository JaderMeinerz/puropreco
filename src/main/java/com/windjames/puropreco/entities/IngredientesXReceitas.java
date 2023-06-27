package com.windjames.puropreco.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_ingredientesreceitas")
public class IngredientesXReceitas {

    @EmbeddedId
    private IngredientesXReceitasPK id = new IngredientesXReceitasPK();
    
    private Integer position;
    
    @NotNull(message = "O campo Quantidade Utilizada deve ser preenchido.")
    private long quantidadeIngrediente;

    public IngredientesXReceitas(Receitas receitas, Ingredientes ingredientes, Integer position, Long quantidadeIngrediente){
        id.setIngredientes(ingredientes);
        id.setReceitas(receitas);
        this.position = position;
        this.quantidadeIngrediente = quantidadeIngrediente;
    }
}
