package com.windjames.puropreco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.windjames.puropreco.entities.Ingredientes;

public interface IngredientesRepository extends JpaRepository<Ingredientes, Long>{
    
}
