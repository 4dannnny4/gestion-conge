package com.dxc.gestion_conge.service;

import java.util.List;

public interface AbstractService <E,I>{
    E findById(I id);
    List<E> findAll();
    E save(E entity);
    E update(E entity, I id);
    void deleteById(I id);
}
