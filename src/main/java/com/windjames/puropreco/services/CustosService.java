package com.windjames.puropreco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.windjames.puropreco.dto.CustosDTO;
import com.windjames.puropreco.entities.Custos;
import com.windjames.puropreco.repositories.CustosRepository;

@Service
public class CustosService {
    
    @Autowired
    private CustosRepository custosRepository;

    public Custos save(CustosDTO custosDTO){
        Custos custos = new Custos();
        custos.setIdCusto(custosDTO.getIdCusto());
        custos.setNomeCusto(custosDTO.getNomeCusto());
        custos.setValorCusto(custosDTO.getValorCusto());
        custos.setFixoVariavel(custosDTO.getFixoVariavel());

        return custosRepository.save(custos);
    }

     @Transactional(readOnly = true)
    public List<CustosDTO> findAll(){
        List<Custos> result = custosRepository.findAll();
        List<CustosDTO> dto = result.stream().map(x -> new CustosDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public CustosDTO findByID(Long idCusto){
        try {
            Custos result = custosRepository.findById(idCusto).get();
            CustosDTO dto = new CustosDTO(result);
            return dto;
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("%s não é um id válido", idCusto));
        }
        
    }

    public Custos update(CustosDTO custosDTO, Long idCusto){
        try{
            Custos custos = custosRepository.findById(idCusto).get();
        custos.setNomeCusto(custosDTO.getNomeCusto());
        custos.setValorCusto(custosDTO.getValorCusto());
        custos.setFixoVariavel(custosDTO.getFixoVariavel());

        return custosRepository.save(custos);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("%s não é um id válido", idCusto));
        }
        
    }

    public void delete(Long idCusto){
        try {
            Custos custos = custosRepository.findById(idCusto).get();
            custosRepository.delete(custos); 
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("%s não é um id válido", idCusto));
        }
    }

    
}

