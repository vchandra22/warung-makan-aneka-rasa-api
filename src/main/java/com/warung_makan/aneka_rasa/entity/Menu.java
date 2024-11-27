package com.warung_makan.aneka_rasa.entity;

import com.warung_makan.aneka_rasa.constant.Constant;
import com.warung_makan.aneka_rasa.constant.MenuCategory;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = Constant.MENU_TABLE)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(nullable = false)
    private Integer stock;

    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private MenuCategory category;
}
