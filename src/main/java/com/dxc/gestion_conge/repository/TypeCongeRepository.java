package com.dxc.gestion_conge.repository;

import com.dxc.gestion_conge.entity.TypeConge;
import com.dxc.gestion_conge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCongeRepository extends JpaRepository<TypeConge, Long> {
}
