package com.dxc.gestion_conge.controller;

import com.dxc.gestion_conge.entity.User;
import com.dxc.gestion_conge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @GetMapping("/get/list")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<User> save(@RequestBody User entity){
        return ResponseEntity.ok(userService.save(entity));
    }

    @PutMapping("/edit")
    public ResponseEntity<User> update(@RequestBody User entity, @PathVariable Long id){
        return ResponseEntity.ok(userService.update(entity, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> update(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
