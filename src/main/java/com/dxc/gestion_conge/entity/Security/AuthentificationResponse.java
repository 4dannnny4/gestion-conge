package com.dxc.gestion_conge.entity.Security;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthentificationResponse {
    private String token;
    private List<String> roles;
    private Long userId;
}
