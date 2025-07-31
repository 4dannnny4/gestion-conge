package com.dxc.gestion_conge.controller;

import com.dxc.gestion_conge.entity.TypeConge;
import com.dxc.gestion_conge.service.TypeCongeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/typeConges")
public class TypeCongeController { 
    
    private final TypeCongeService typeCongeService;

    public TypeCongeController(TypeCongeService typeCongeService) {
        this.typeCongeService = typeCongeService;
    }

    @GetMapping("/get")
    public ResponseEntity<TypeConge> findById(@PathVariable Long id){
        return ResponseEntity.ok(typeCongeService.findById(id));
    }
    @GetMapping("/get/list")
    public ResponseEntity<List<TypeConge>> findAll(){
        return ResponseEntity.ok(typeCongeService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<TypeConge> save(@RequestBody TypeConge entity){
        return ResponseEntity.ok(typeCongeService.save(entity));
    }

    @PutMapping("/edit")
    public ResponseEntity<TypeConge> update(@RequestBody TypeConge entity, @PathVariable Long id){
        return ResponseEntity.ok(typeCongeService.update(entity, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> update(@PathVariable Long id){
        typeCongeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


