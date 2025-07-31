package com.dxc.gestion_conge.controller;

import com.dxc.gestion_conge.entity.DemandeConge;
import com.dxc.gestion_conge.service.DemandeCongeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/demandeConges")
public class DemandeCongeController {

    private final DemandeCongeService DemandeCongeService;

    public DemandeCongeController(DemandeCongeService DemandeCongeService) {
        this.DemandeCongeService = DemandeCongeService;
    }

    @GetMapping("/get")
    public ResponseEntity<DemandeConge> findById(@PathVariable Long id){
        return ResponseEntity.ok(DemandeCongeService.findById(id));
    }
    @GetMapping("/get/list")
    public ResponseEntity<List<DemandeConge>> findAll(){
        return ResponseEntity.ok(DemandeCongeService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<DemandeConge> save(@RequestBody DemandeConge entity){
        return ResponseEntity.ok(DemandeCongeService.save(entity));
    }

    @PutMapping("/edit")
    public ResponseEntity<DemandeConge> update(@RequestBody DemandeConge entity, @PathVariable Long id){
        return ResponseEntity.ok(DemandeCongeService.update(entity, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> update(@PathVariable Long id){
        DemandeCongeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

