package com.warung_makan.aneka_rasa.entity;

import com.warung_makan.aneka_rasa.constant.Constant;
import com.warung_makan.aneka_rasa.constant.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Constant.USER_TABLE)
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;
}
