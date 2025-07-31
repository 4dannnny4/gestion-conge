package com.dxc.gestion_conge.service;

import com.dxc.gestion_conge.entity.Role;
import com.dxc.gestion_conge.entity.SoldeConge;
import com.dxc.gestion_conge.entity.User;
import com.dxc.gestion_conge.repository.RoleRepository;
import com.dxc.gestion_conge.repository.SoldeCongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements AbstractService<Role, Long>{
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Role> findAll() {
       List< Role > foundedRole=roleRepository.findAll();
        return foundedRole;
    }

    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Role update(Role entity, Long id) {

       Role foundedRole=roleRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found with the id: "+id)
        );
        foundedRole.setId(entity.getId());
        foundedRole.setNom(entity.getNom());


        return foundedRole;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
       roleRepository.deleteById(id);

    }
}
