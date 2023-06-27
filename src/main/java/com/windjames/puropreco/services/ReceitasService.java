package com.windjames.puropreco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.windjames.puropreco.dto.ReceitasDTO;
import com.windjames.puropreco.dto.ReceitasMinDTO;
import com.windjames.puropreco.entities.Receitas;
import com.windjames.puropreco.repositories.ReceitasRepository;

@Service
public class ReceitasService {
    
    @Autowired
    ReceitasRepository receitasRepository;

    public Receitas save(ReceitasDTO receitasDTO){
        Receitas receita = new Receitas();

        receita.setNomeReceita(receitasDTO.getNomeReceita());
        receita.setIdReceitas(receitasDTO.getIdReceitas());
        receita.setRendimento(receitasDTO.getRendimento());
        receita.setPesoUnidade(receitasDTO.getPesoUnidade());
        receita.setTempoPreparo(receitasDTO.getTempoPreparo());

        return receitasRepository.save(receita);
    }

    @Transactional(readOnly = true)
    public List<ReceitasMinDTO> findAll(){
        List<Receitas> result = receitasRepository.findAll();
        List<ReceitasMinDTO> dto = result.stream().map(x -> new ReceitasMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public ReceitasDTO findById(Long idReceitas){
        try {
            Receitas result = receitasRepository.findById(idReceitas).get();
            ReceitasDTO dto = new ReceitasDTO(result);
            return dto;
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("%s não é um id válido", idReceitas));   
        }
    }

    public Receitas update(ReceitasDTO receitasDTO, Long idReceitas){
        try {
           Receitas receita = receitasRepository.findById(idReceitas).get();
            receita.setRendimento(receitasDTO.getRendimento());
            receita.setPesoUnidade(receitasDTO.getPesoUnidade());
            receita.setTempoPreparo(receitasDTO.getTempoPreparo());

          return receitasRepository.save(receita); 
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("%s não é um id válido", idReceitas));   
        }
        
    }

    public void delete (Long idReceitas){
        try {
            Receitas receita = receitasRepository.findById(idReceitas).get();
            receitasRepository.delete(receita);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("%s não é um id válido", idReceitas));   
        }
    }
}