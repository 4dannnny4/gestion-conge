package com.dxc.gestion_conge.repository;

import com.dxc.gestion_conge.entity.Role;
import com.dxc.gestion_conge.entity.SoldeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNom(String nom);
}
