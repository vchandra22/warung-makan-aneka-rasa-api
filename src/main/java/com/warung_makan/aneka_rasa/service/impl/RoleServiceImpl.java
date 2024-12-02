package com.warung_makan.aneka_rasa.service.impl;

import com.warung_makan.aneka_rasa.constant.UserRole;
import com.warung_makan.aneka_rasa.entity.Role;
import com.warung_makan.aneka_rasa.repository.RoleRepository;
import com.warung_makan.aneka_rasa.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role getRole(UserRole role) {
        return roleRepository.findByRole(role).orElseThrow(() -> new RuntimeException("Role Not Found"));
    }
}
