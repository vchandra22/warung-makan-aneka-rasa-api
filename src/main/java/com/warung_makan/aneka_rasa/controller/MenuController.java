package com.warung_makan.aneka_rasa.controller;

import com.warung_makan.aneka_rasa.constant.Constant;
import com.warung_makan.aneka_rasa.dto.request.MenuRequest;
import com.warung_makan.aneka_rasa.dto.response.MenuResponse;
import com.warung_makan.aneka_rasa.service.MenuService;
import com.warung_makan.aneka_rasa.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
