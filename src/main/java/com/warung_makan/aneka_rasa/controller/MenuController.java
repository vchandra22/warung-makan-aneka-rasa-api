package com.warung_makan.aneka_rasa.controller;

import com.warung_makan.aneka_rasa.constant.Constant;
import com.warung_makan.aneka_rasa.dto.request.MenuRequest;
import com.warung_makan.aneka_rasa.dto.response.MenuResponse;
import com.warung_makan.aneka_rasa.service.MenuService;
import com.warung_makan.aneka_rasa.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
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
}
