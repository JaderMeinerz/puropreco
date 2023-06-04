package com.windjames.puropreco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(value = "/custos")
public class CustosController {
    
    @Autowired
    private CustosService custosService;
   
    //Create
    @PostMapping
    public Custos postCustos(@RequestBody CustosDTO custosDTO){
        Custos _custos = custosService.save(custosDTO);
        return _custos;
    } 
   
    //Read  
    @GetMapping
    public List<CustosDTO> findAll(){
        List<CustosDTO> result = custosService.findAll();
        return result;
    }
    @GetMapping(value = "/{idCusto}")
    public CustosDTO findById(@PathVariable Long idCusto){
        CustosDTO result = custosService.findByID(idCusto);
        return result;
    }

    //Update
    @PutMapping(value = "/{idCusto}")
    public Custos updateCustos(@RequestBody CustosDTO custosDTO, @PathVariable Long idCusto){
        Custos custos = custosService.update(custosDTO, idCusto);
        return custos;
    }

    //Delete
    @DeleteMapping(value = "/{idCusto}")
    public void deleteCustos(@PathVariable Long idCusto){
        custosService.delete(idCusto);
    }
}
