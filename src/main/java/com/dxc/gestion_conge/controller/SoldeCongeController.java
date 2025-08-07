package com.dxc.gestion_conge.controller;
import com.dxc.gestion_conge.entity.SoldeConge;
import com.dxc.gestion_conge.service.SoldeCongeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/soldeConges")
@CrossOrigin(origins = "http://localhost:4200")
public class SoldeCongeController {
    private final SoldeCongeService SoldeCongeService;

    public SoldeCongeController(SoldeCongeService SoldeCongeService) {
        this.SoldeCongeService = SoldeCongeService;
    }

    @GetMapping("/get")
    public ResponseEntity<SoldeConge> findById(@PathVariable Long id){
        return ResponseEntity.ok(SoldeCongeService.findById(id));
    }
    @GetMapping("/get/list")
    public ResponseEntity<List<SoldeConge>> findAll(){
        return ResponseEntity.ok(SoldeCongeService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<SoldeConge> save(@RequestBody SoldeConge entity){
        return ResponseEntity.ok(SoldeCongeService.save(entity));
    }

    @PutMapping("/edit")
    public ResponseEntity<SoldeConge> update(@RequestBody SoldeConge entity, @PathVariable Long id){
        return ResponseEntity.ok(SoldeCongeService.update(entity, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> update(@PathVariable Long id){
        SoldeCongeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}



    
    
    
    
    
    
    
    

