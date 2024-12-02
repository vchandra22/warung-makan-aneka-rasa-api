package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.constant.UserRole;
import com.warung_makan.aneka_rasa.entity.Role;

public interface RoleService {
    Role getRole(UserRole role);
}
