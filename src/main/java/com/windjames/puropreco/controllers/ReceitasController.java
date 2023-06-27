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

import com.windjames.puropreco.dto.ReceitasDTO;
import com.windjames.puropreco.dto.ReceitasMinDTO;
import com.windjames.puropreco.entities.Receitas;
import com.windjames.puropreco.services.ReceitasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/receitas")
public class ReceitasController {
    
    @Autowired
    ReceitasService receitasService;

    //create
    @PostMapping
    public ResponseEntity<Receitas> saveReceita(@Valid @RequestBody ReceitasDTO receitasDTO){
        Receitas result = receitasService.save(receitasDTO);
        return new ResponseEntity<Receitas>(result, HttpStatus.OK);
    }
    //read
    @GetMapping
    public ResponseEntity<List<ReceitasMinDTO>> findAll(){
        List<ReceitasMinDTO> result = receitasService.findAll();
        return new ResponseEntity<List<ReceitasMinDTO>>(result, HttpStatus.OK);
    }
    @GetMapping(value = "/{idReceitas}")
    public ResponseEntity<ReceitasDTO> findById(@PathVariable Long idReceitas){
        ReceitasDTO result = receitasService.findById(idReceitas);
        return new ResponseEntity<ReceitasDTO>(result, HttpStatus.OK);
    }
    //update
    @PutMapping(value = "/{idReceitas}")
    public ResponseEntity<Receitas> updateReceitas(@Valid @RequestBody ReceitasDTO receitasDTO, @PathVariable Long idReceitas){
        Receitas result = receitasService.update(receitasDTO, idReceitas);
        return new ResponseEntity<Receitas>(result, HttpStatus.OK);
    }
    //delete
    @DeleteMapping(value = "/{idReceitas}")
    public void deleteReceitas(@PathVariable Long idReceitas){
        receitasService.delete(idReceitas);
    }
}
