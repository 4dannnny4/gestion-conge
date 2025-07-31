package com.dxc.gestion_conge.service;

import com.dxc.gestion_conge.entity.SoldeConge;
import com.dxc.gestion_conge.entity.TypeConge;
import com.dxc.gestion_conge.entity.User;
import com.dxc.gestion_conge.repository.SoldeCongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SoldeCongeService implements AbstractService<SoldeConge, Long>{
    @Autowired
    private SoldeCongeRepository soldeCongeRepository;
    @Override
    public SoldeConge findById(Long id) {
        return soldeCongeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<SoldeConge> findAll() {
        List<SoldeConge> foundedSoldeConge=soldeCongeRepository.findAll();
        return foundedSoldeConge;
    }

    @Override
    public SoldeConge save(SoldeConge entity) {
        return soldeCongeRepository.save(entity);
    }

    @Override
    public SoldeConge update(SoldeConge entity, Long id) {

        SoldeConge foundedSoldeConge=soldeCongeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found with the id: "+id)
        );
        foundedSoldeConge.setId(entity.getId());
        foundedSoldeConge.setTotalAnnuel(entity.getTotalAnnuel());
        foundedSoldeConge.setRestant(entity.getRestant());
        foundedSoldeConge.setUtilise(entity.getUtilise());

        return foundedSoldeConge;


    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        soldeCongeRepository.deleteById(id);
    }
}
