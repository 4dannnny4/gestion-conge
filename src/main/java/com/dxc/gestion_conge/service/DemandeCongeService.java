package com.dxc.gestion_conge.service;

import com.dxc.gestion_conge.entity.DemandeConge;
import com.dxc.gestion_conge.entity.Role;
import com.dxc.gestion_conge.entity.SoldeConge;
import com.dxc.gestion_conge.entity.User;
import com.dxc.gestion_conge.repository.DemandeCongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandeCongeService implements AbstractService<DemandeConge, Long>{
    @Autowired
    private DemandeCongeRepository demandeCongeRepository ;
    @Override
    public DemandeConge findById(Long id) {
        return demandeCongeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<DemandeConge> findAll() {
        List<DemandeConge> foundedDemandeConge=demandeCongeRepository.findAll();
        return foundedDemandeConge;
    }

    @Override
    public DemandeConge save(DemandeConge entity) {
        return demandeCongeRepository.save(entity);
    }

    @Override
    public DemandeConge update(DemandeConge entity, Long id) {
        DemandeConge foundedDemandeConge=demandeCongeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found with the id: "+id)
        );
        foundedDemandeConge.setId(entity.getId());
        foundedDemandeConge.setDateDebut(entity.getDateDebut());
        foundedDemandeConge.setDateFin(entity.getDateFin());
        foundedDemandeConge.setType(entity.getType());

        return foundedDemandeConge;

    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        demandeCongeRepository.deleteById(id);
    }
}
