package com.warung_makan.aneka_rasa.repository;

import com.warung_makan.aneka_rasa.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserAccount, UUID> {
    UserAccount findByUsernameAndPassword(String username, String password);
    Optional<UserAccount> findByUsername(String username);
}
