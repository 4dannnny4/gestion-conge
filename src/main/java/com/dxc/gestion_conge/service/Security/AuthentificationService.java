package com.dxc.gestion_conge.service.Security;

import com.dxc.gestion_conge.entity.Role;
import com.dxc.gestion_conge.entity.Security.AuthentificationRequest;
import com.dxc.gestion_conge.entity.Security.AuthentificationResponse;
import com.dxc.gestion_conge.entity.Security.RegisterDto;
import com.dxc.gestion_conge.entity.User;
import com.dxc.gestion_conge.repository.RoleRepository;
import com.dxc.gestion_conge.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthentificationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userDao;
    private final RoleRepository roleDao;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthentificationResponse authenticate (AuthentificationRequest request) {
        System.out.println("Authenticating user: " + request.getUsername());
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userDao.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + request.getUsername()));

        var jwtToken = jwtTokenProvider.generateToken(user);
        var roles = user.getRoles().stream()
                .map(Role::getNom)
                .collect(Collectors.toList());
        var userId=user.getId();

        return AuthentificationResponse.builder()
                .token(jwtToken)
                .roles(roles)
                .userId(userId)
                .build();
    }

    public String register(RegisterDto registerDto) {

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleDao.findByNom("ROLE_EMPLOYEE");
        userRole.ifPresent(roles::add);

        user.setRoles(roles);

        userDao.save(user);

        return "User register successfully";
    }
}
