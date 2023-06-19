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

import com.windjames.puropreco.dto.CustosDTO;
import com.windjames.puropreco.entities.Custos;
import com.windjames.puropreco.services.CustosService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/custos")
public class CustosController {
    
    @Autowired 
    private CustosService custosService;
   
    //Create
    @PostMapping
    public ResponseEntity<Custos> postCustos(@Valid @RequestBody CustosDTO custosDTO){
        Custos _custos = custosService.save(custosDTO);
        return new ResponseEntity<Custos>(_custos, HttpStatus.OK);
    } 
   
    //Read  
    @GetMapping
    public ResponseEntity<List<CustosDTO>> findAll(){
        List<CustosDTO>  result = custosService.findAll();
        return new ResponseEntity<List<CustosDTO>>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{idCusto}")
    public ResponseEntity<CustosDTO> findById(@PathVariable Long idCusto){
        CustosDTO result = custosService.findByID(idCusto);
        return new ResponseEntity<CustosDTO>(result, HttpStatus.OK);
    }

    //Update
    @PutMapping(value = "/{idCusto}")
    public ResponseEntity<Custos> updateCustos(@Valid @RequestBody CustosDTO custosDTO, @PathVariable Long idCusto){
        Custos custos = custosService.update(custosDTO, idCusto);
        return new ResponseEntity<Custos>(custos, HttpStatus.OK);
    }

    //Delete
    @DeleteMapping(value = "/{idCusto}")
    public void deleteCustos(@PathVariable Long idCusto){
        custosService.delete(idCusto);
    }
}
