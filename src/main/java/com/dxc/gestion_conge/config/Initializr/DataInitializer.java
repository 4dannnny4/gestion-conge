package com.dxc.gestion_conge.config.Initializr;

import com.dxc.gestion_conge.entity.Role;
import com.dxc.gestion_conge.entity.User;
import com.dxc.gestion_conge.repository.RoleRepository;
import com.dxc.gestion_conge.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userDao;
    private final RoleRepository roleDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Role rhRole;
        Role adminRole;
        Role managerRole;
        Role employeRole;

        var roleOpt = roleDao.findByNom("ROLE_ADMIN");
        var roleRh=roleDao.findByNom("ROLE_RH");
        var roleMn=roleDao.findByNom("ROLE_MANAGER");
        var roleEmp=roleDao.findByNom("ROLE_EMPLOYE");
        if (roleOpt.isPresent() && roleEmp.isPresent()) {
            adminRole = roleOpt.get();
            employeRole = roleEmp.get();
        } else {
            adminRole = new Role();
            adminRole.setNom("ROLE_ADMIN");
            adminRole = roleDao.save(adminRole);

            employeRole= new Role();
            employeRole.setNom("ROLE_EMPLOYE");
            employeRole = roleDao.save(employeRole);
        }

        if (userDao.findByUsername("admin").isEmpty()) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));

            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            admin.setRoles(adminRoles);

            userDao.save(admin);
        }
        if (userDao.findByUsername("employe").isEmpty()) {
            User employe = new User();
            employe.setUsername("employe");
            employe.setPassword(passwordEncoder.encode("employe"));

            Set<Role> employeRoles = new HashSet<>();
            employeRoles.add(employeRole);
            employe.setRoles(employeRoles);

            userDao.save(employe);
        }
        if(roleDao.findByNom("ROLE_MANAGER").isEmpty()){
            managerRole=new Role();
            managerRole.setNom("ROLE_MANAGER");
            roleDao.save(managerRole);
        }
        if(roleDao.findByNom("ROLE_RH").isEmpty()){
            rhRole=new Role();
            rhRole.setNom("ROLE_RH");
            roleDao.save(rhRole);
        }
    }
}