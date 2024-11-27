package com.warung_makan.aneka_rasa.service.impl;

import com.warung_makan.aneka_rasa.constant.MenuCategory;
import com.warung_makan.aneka_rasa.dto.request.MenuRequest;
import com.warung_makan.aneka_rasa.dto.response.MenuResponse;
import com.warung_makan.aneka_rasa.entity.Menu;
import com.warung_makan.aneka_rasa.repository.MenuRepository;
import com.warung_makan.aneka_rasa.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    @Override
    public MenuResponse createMenu(MenuRequest menuRequest) {
        Menu menu = Menu.builder()
                .name(menuRequest.getName())
                .price(menuRequest.getPrice())
                .category(MenuCategory.fromValue(menuRequest.getCategory()))
                .isAvailable(true)
                .stock(menuRequest.getStock())
                .build();
        menuRepository.saveAndFlush(menu);
        return toMenuResponse(menu);
    }

    @Override
    public MenuResponse getMenuById(String id) {
        Menu menu = getOne(id);

        return toMenuResponse(menu);
    }

    @Override
    public Menu getOne(String id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu not found"));
    }

    private MenuResponse toMenuResponse(Menu menu) {
        MenuResponse menuResponse = new MenuResponse();
        menuResponse.setId(String.valueOf(menu.getId()));
        menuResponse.setName(menu.getName());
        menuResponse.setPrice(menu.getPrice());
        menuResponse.setStock(menu.getStock());
        menuResponse.setCategory(menu.getCategory().toString());

        return menuResponse;
    }
}
