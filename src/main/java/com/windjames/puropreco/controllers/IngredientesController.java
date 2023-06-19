package com.windjames.puropreco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.windjames.puropreco.dto.IngredientesDTO;
import com.windjames.puropreco.entities.Ingredientes;
import com.windjames.puropreco.services.IngredientesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/ingredientes")
public class IngredientesController {
    
    @Autowired
    IngredientesService ingredientesService;

    //create
    @PostMapping
    public ResponseEntity<Ingredientes> saveIngredientes(@Valid @RequestBody IngredientesDTO ingredientesDTO){
        Ingredientes result = ingredientesService.save(ingredientesDTO);
        return new ResponseEntity<Ingredientes>(result, HttpStatus.OK);
    }
    //read
    @GetMapping
    public ResponseEntity<List<IngredientesDTO>> findAll(){
        List<IngredientesDTO> result = ingredientesService.findAll();
        return new ResponseEntity<List<IngredientesDTO>>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{idIngredientes}")
    public ResponseEntity<IngredientesDTO> findByID(@PathVariable Long idIngredientes){
        IngredientesDTO result = ingredientesService.findById(idIngredientes);
        return new ResponseEntity<IngredientesDTO>(result, HttpStatus.OK);
    }
    //update
    @PutMapping(value = "/{idIngredientes}")
    public ResponseEntity<Ingredientes> updateIngrediente(@Valid @RequestBody IngredientesDTO ingredientesDTO, @PathVariable Long idIngredientes){
        Ingredientes result = ingredientesService.update(ingredientesDTO, idIngredientes);
        return new ResponseEntity<Ingredientes>(result, HttpStatus.OK);
    }

    //delete
    @DeleteMapping(value = "/{idIngredientes}")
    public void deleteIngredientes(@PathVariable long idIngredientes){
        ingredientesService.delete(idIngredientes);
    }
}
