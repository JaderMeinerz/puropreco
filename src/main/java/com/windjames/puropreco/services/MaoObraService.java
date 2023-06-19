package com.windjames.puropreco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.windjames.puropreco.dto.MaoObraDTO;
import com.windjames.puropreco.entities.MaoObra;
import com.windjames.puropreco.repositories.MaoObraRepository;

@Service
public class MaoObraService {
    
    @Autowired
    MaoObraRepository maoObraRepository;

    @Transactional(readOnly = true)
    public List<MaoObraDTO> findAll(){
        List <MaoObra> result = maoObraRepository.findAll();
        List<MaoObraDTO> dto =  result.stream().map(x -> new MaoObraDTO(x)).toList();
        return dto;
    }

    public MaoObra save(MaoObraDTO maoObraDTO){
        MaoObra maoObra = new MaoObra();

        maoObra.setIdMaoObra(maoObraDTO.getIdMaoObra());
        maoObra.setSalario(maoObraDTO.getSalario());
        maoObra.setHoraTrabalho(maoObraDTO.getHoraTrabalho());

        return maoObraRepository.save(maoObra);
    }

    public MaoObra update(MaoObraDTO maoObraDTO, Long idMaoObra){
        MaoObra maoObra = maoObraRepository.findById(idMaoObra).get();

        maoObra.setSalario(maoObraDTO.getSalario());
        maoObra.setHoraTrabalho(maoObraDTO.getHoraTrabalho());

        return maoObraRepository.save(maoObra);
    }

    public void delete(Long idMaoObra){
        MaoObra maoObra = maoObraRepository.findById(idMaoObra).get();
        maoObraRepository.delete(maoObra);
    }
}
