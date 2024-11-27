package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.dto.request.MenuRequest;
import com.warung_makan.aneka_rasa.dto.response.MenuResponse;
import com.warung_makan.aneka_rasa.entity.Menu;

public interface MenuService {
    MenuResponse createMenu(MenuRequest menuRequest);
    MenuResponse getMenuById(String id);
    Menu getOne(String id);
}
