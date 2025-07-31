package com.dxc.gestion_conge.service;

import com.dxc.gestion_conge.entity.TypeConge;
import com.dxc.gestion_conge.entity.User;
import com.dxc.gestion_conge.repository.TypeCongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCongeService implements AbstractService<TypeConge, Long>{
    @Autowired
    private TypeCongeRepository typeCongeRepository;

    @Override
    public TypeConge findById(Long id) {
        return typeCongeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<TypeConge> findAll() {
         List<TypeConge> foundedTypeConge=typeCongeRepository.findAll();
        return foundedTypeConge;
    }

    @Override
    public TypeConge save(TypeConge entity) {
        return typeCongeRepository.save(entity);
    }

    @Override
    public TypeConge update(TypeConge entity, Long id) {
        TypeConge foundedTypeConge=typeCongeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found with the id: "+id)
        );
        foundedTypeConge.setNom(entity.getNom());
        foundedTypeConge.setDescription(entity.getDescription());

        return foundedTypeConge;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        typeCongeRepository.deleteById(id);
    }
}
