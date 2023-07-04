package com.windjames.puropreco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.windjames.puropreco.dto.IngredientesDTO;
import com.windjames.puropreco.entities.Ingredientes;
import com.windjames.puropreco.repositories.IngredientesRepository;

@Service
public class IngredientesService {
    
    @Autowired
    private IngredientesRepository ingredientesRepository;

    public Ingredientes save(IngredientesDTO ingredientesDTO){
        Ingredientes ingredientes = new Ingredientes();
        ingredientes.setIdIngredientes(ingredientesDTO.getIdIngredientes());
        ingredientes.setNome(ingredientesDTO.getNome());
        ingredientes.setMedida(ingredientesDTO.getMedida());
        ingredientes.setUnidadeMedida(ingredientesDTO.getUnidadeMedida());
        ingredientes.setPreco(ingredientesDTO.getPreco());

        return ingredientesRepository.save(ingredientes);
    }

    @Transactional(readOnly = true)
    public List<IngredientesDTO> findAll(){
        List<Ingredientes> result = ingredientesRepository.findAll();
        List <IngredientesDTO> dto = result.stream().map(x -> new IngredientesDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public IngredientesDTO findById(Long idIngredientes){
        try {
            Ingredientes result = ingredientesRepository.findById(idIngredientes).get();
            IngredientesDTO dto = new IngredientesDTO(result);
            return dto;
        } catch (Exception e) {
            throw new IllegalArgumentException("%s não é um id válido".formatted(idIngredientes));   
        }
    }

    public Ingredientes update (IngredientesDTO ingredientesDTO, Long idIngredientes){
        try {
            Ingredientes ingredientes = ingredientesRepository.findById(idIngredientes).get();
            ingredientes.setNome(ingredientesDTO.getNome());
            ingredientes.setMedida(ingredientesDTO.getMedida());
            ingredientes.setUnidadeMedida(ingredientesDTO.getUnidadeMedida());
            ingredientes.setPreco(ingredientesDTO.getPreco());

            return ingredientesRepository.save(ingredientes);
        } catch (Exception e) {
            throw new IllegalArgumentException("%s não é um id válido".formatted(idIngredientes));
        }
    }

    public void delete(Long idIngredientes){
        try {
            Ingredientes ingrediente = ingredientesRepository.findById(idIngredientes).get();
            ingredientesRepository.delete(ingrediente);
        } catch (Exception e) {
            throw new IllegalArgumentException("%s não é um id válido".formatted(idIngredientes));
        }
        
    }
}
