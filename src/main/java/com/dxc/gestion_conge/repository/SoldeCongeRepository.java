package com.dxc.gestion_conge.repository;

import com.dxc.gestion_conge.entity.SoldeConge;
import com.dxc.gestion_conge.entity.TypeConge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldeCongeRepository extends JpaRepository<SoldeConge, Long> {
}
