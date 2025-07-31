package com.dxc.gestion_conge.service;

import com.dxc.gestion_conge.entity.User;
import com.dxc.gestion_conge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements AbstractService<User, Long>{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List<User> findAll() {
        List<User> foundedUsers=userRepository.findAll();
        return foundedUsers;
    }

    @Override
    public User save(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(User entity, Long id) {
        User foundedUser=userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found with the id: "+id)
        );
        foundedUser.setId(entity.getId());
        foundedUser.setUsername(entity.getUsername());
        foundedUser.setEmail(entity.getEmail());
        foundedUser.setPassword(entity.getPassword());
        foundedUser.setRoles(entity.getRoles());

        return foundedUser;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        userRepository.deleteById(id);
    }




}
