package com.warung_makan.aneka_rasa.repository;

import com.warung_makan.aneka_rasa.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuRepository extends JpaRepository<Menu, String>, JpaSpecificationExecutor<Menu> {

}
