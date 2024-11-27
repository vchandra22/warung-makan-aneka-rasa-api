package com.warung_makan.aneka_rasa.controller;

import com.warung_makan.aneka_rasa.constant.Constant;
import com.warung_makan.aneka_rasa.dto.request.MenuRequest;
import com.warung_makan.aneka_rasa.dto.request.SearchMenuRequest;
import com.warung_makan.aneka_rasa.dto.response.MenuResponse;
import com.warung_makan.aneka_rasa.service.MenuService;
import com.warung_makan.aneka_rasa.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(Constant.MENU_API)
@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<?> createNewMenu(@RequestBody MenuRequest request) {
        MenuResponse createdMenu = menuService.createMenu(request);

        return ResponseUtil.buildResponse(HttpStatus.CREATED, Constant.SUCCESS_CREATE_MENU, createdMenu);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getMenu(@PathVariable String id) {
        MenuResponse singleMenu = menuService.getMenuById(id);

        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_GET_MENU, singleMenu);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateMenu(@PathVariable String id, @RequestBody MenuRequest menuRequest) {
        MenuResponse updateMenu = menuService.updateMenu(id, menuRequest);

        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_UPDATE_MENU, updateMenu);
    }

    @GetMapping
    public ResponseEntity<?> getAllMenu(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "minPrice", required = false) Long minPrice,
            @RequestParam(name = "maxPrice", required = false) Long maxPrice,
            @RequestParam(name = "isReady", required = false) Boolean isReady,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size,
            @RequestParam(name = "sort", required = false, defaultValue = "name") String sort
            ) {
        SearchMenuRequest searchMenuRequest = SearchMenuRequest.builder()
                .name(name)
                .category(category)
                .minPrice(minPrice)
                .maxPrice(maxPrice)
                .isReady(isReady)
                .page(page)
                .size(size)
                .sort(sort)
                .build();

        Page<MenuResponse> menuResponses = menuService.getAllMenu(searchMenuRequest);
        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_GET_ALL_MENU, menuResponses);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteMenu(@PathVariable String id) {
        menuService.deleteMenu(id);

        return ResponseUtil.buildResponse(HttpStatus.OK, Constant.SUCCESS_DELETE_MENU, null);
    }

}
