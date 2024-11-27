package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.dto.request.MenuRequest;
import com.warung_makan.aneka_rasa.dto.response.MenuResponse;

public interface MenuService {
    MenuResponse createMenu(MenuRequest menuRequest);
}
