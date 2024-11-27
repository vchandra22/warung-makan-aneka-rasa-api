package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.dto.request.MenuRequest;
import com.warung_makan.aneka_rasa.dto.request.SearchMenuRequest;
import com.warung_makan.aneka_rasa.dto.response.MenuResponse;
import com.warung_makan.aneka_rasa.entity.Menu;
import org.springframework.data.domain.Page;

public interface MenuService {
    MenuResponse createMenu(MenuRequest menuRequest);
    MenuResponse getMenuById(String id);
    MenuResponse updateMenu(String id, MenuRequest menuRequest);
    Menu getOne(String id);
    Page<MenuResponse> getAllMenu(SearchMenuRequest searchMenuRequest);
    void deleteMenu(String id);
}
