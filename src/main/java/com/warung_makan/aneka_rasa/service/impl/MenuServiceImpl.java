package com.warung_makan.aneka_rasa.service.impl;

import com.warung_makan.aneka_rasa.constant.MenuCategory;
import com.warung_makan.aneka_rasa.dto.request.MenuRequest;
import com.warung_makan.aneka_rasa.dto.request.SearchMenuRequest;
import com.warung_makan.aneka_rasa.dto.response.MenuResponse;
import com.warung_makan.aneka_rasa.entity.Menu;
import com.warung_makan.aneka_rasa.repository.MenuRepository;
import com.warung_makan.aneka_rasa.service.MenuService;
import com.warung_makan.aneka_rasa.specification.MenuSpecification;
import com.warung_makan.aneka_rasa.util.SortUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
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
    public MenuResponse updateMenu(String id, MenuRequest menuRequest) {
        Menu currentMenu = getOne(id);

        currentMenu.setId(id);
        currentMenu.setName(menuRequest.getName());
        currentMenu.setPrice(menuRequest.getPrice());
        currentMenu.setStock(menuRequest.getStock());
        currentMenu.setCategory(MenuCategory.fromValue(menuRequest.getCategory()));

        menuRepository.save(currentMenu);

        return toMenuResponse(currentMenu);
    }

    @Override
    public Menu getOne(String id) {
        return menuRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu not found"));
    }

    @Override
    public Page<MenuResponse> getAllMenu(SearchMenuRequest searchMenuRequest) {
        Pageable menuPageable = PageRequest.of(
                (searchMenuRequest.getPage() - 1),
                searchMenuRequest.getSize(),
                SortUtil.parseSortFromQueryParam(searchMenuRequest.getSort())
        );

        Specification<Menu> menuSpecification = MenuSpecification.getSpecification(searchMenuRequest);
        Page<Menu> menuPage = menuRepository.findAll(menuSpecification, menuPageable);

        return menuPage.map(this::toMenuResponse);
    }

    @Override
    public void deleteMenu(String id) {
        Menu menu = getOne(id);

        menuRepository.delete(menu);
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
