package com.warung_makan.aneka_rasa.repository;

import com.warung_makan.aneka_rasa.constant.UserRole;
import com.warung_makan.aneka_rasa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRole(UserRole role);
}
