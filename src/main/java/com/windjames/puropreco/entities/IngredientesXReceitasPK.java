package com.windjames.puropreco.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
@Getter
@Setter
public class IngredientesXReceitasPK {

    @ManyToOne
    @JoinColumn(name = "id_ingredientes")
    private Ingredientes ingredientes;

    @ManyToOne
    @JoinColumn(name = "id_receitas")
    private Receitas receitas;

    public IngredientesXReceitasPK(Ingredientes ingredientes, Receitas receitas){
        this.ingredientes = ingredientes;
        this.receitas = receitas;
    }


    
    
}
