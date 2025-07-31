package com.dxc.gestion_conge.repository;

import com.dxc.gestion_conge.entity.DemandeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeCongeRepository extends JpaRepository<DemandeConge, Long> {
}
