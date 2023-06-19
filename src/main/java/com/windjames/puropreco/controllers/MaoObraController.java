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

import com.windjames.puropreco.dto.MaoObraDTO;
import com.windjames.puropreco.entities.MaoObra;
import com.windjames.puropreco.services.MaoObraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/valor")
public class MaoObraController {
    
    @Autowired
    private MaoObraService maoObraService;

    //create
    @PostMapping
    public MaoObra saveMaoObra(@Valid @RequestBody MaoObraDTO maoObraDTO){
        MaoObra result = maoObraService.save(maoObraDTO);
        return result; 
    }

    //read
    @GetMapping
    public List<MaoObraDTO> findAll(){
        List<MaoObraDTO> result = maoObraService.findAll();
        return result;
    }
    
    //update
    @PutMapping(value = "/{idMaoObra}")
    public MaoObra updateMaoObra(@Valid @RequestBody MaoObraDTO maoObraDTO, @PathVariable Long idMaoObra){
        MaoObra result = maoObraService.update(maoObraDTO, idMaoObra);
        return result;
    }

    //delete
    @DeleteMapping(value = "/{idMaoObra}")
    public void deleteMaoObra(@PathVariable Long idMaoObra){
        maoObraService.delete(idMaoObra);
    }
}
