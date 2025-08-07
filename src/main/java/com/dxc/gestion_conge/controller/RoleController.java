package com.dxc.gestion_conge.controller;
import com.dxc.gestion_conge.entity.Role;
import com.dxc.gestion_conge.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RoleController {
    private final RoleService RoleService;

    public RoleController(RoleService RoleService) {
        this.RoleService = RoleService;
    }

    @GetMapping("/get")
    public ResponseEntity<Role> findById(@PathVariable Long id){
        return ResponseEntity.ok(RoleService.findById(id));
    }
    @GetMapping("/get/list")
    public ResponseEntity<List<Role>> findAll(){
        return ResponseEntity.ok(RoleService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Role> save(@RequestBody Role entity){
        return ResponseEntity.ok(RoleService.save(entity));
    }

    @PutMapping("/edit")
    public ResponseEntity<Role> update(@RequestBody Role entity, @PathVariable Long id){
        return ResponseEntity.ok(RoleService.update(entity, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> update(@PathVariable Long id){
        RoleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
