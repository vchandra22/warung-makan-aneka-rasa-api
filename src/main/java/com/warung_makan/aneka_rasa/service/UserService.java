package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.entity.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserAccount getByUserId(String id);
    UserAccount getByContext();
    UserDetails loadUserByUsername(String username);
}
