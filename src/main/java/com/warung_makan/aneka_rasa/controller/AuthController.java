package com.warung_makan.aneka_rasa.controller;

import com.warung_makan.aneka_rasa.constant.Constant;
import com.warung_makan.aneka_rasa.dto.request.AuthRequest;
import com.warung_makan.aneka_rasa.dto.response.LoginResponse;
import com.warung_makan.aneka_rasa.dto.response.RegisterResponse;
import com.warung_makan.aneka_rasa.service.AuthService;
import com.warung_makan.aneka_rasa.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constant.AUTH_API)
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerCustomer(@RequestBody AuthRequest authRequest) {
        RegisterResponse registerResponse = authService.register(authRequest);

        return ResponseUtil.buildResponse(HttpStatus.CREATED, "Register Successfully", registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        LoginResponse loginResponse = authService.login(authRequest);

        return ResponseUtil.buildResponse(HttpStatus.OK, "Successfully Login", loginResponse);
    }

}
