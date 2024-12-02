package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.dto.request.AuthRequest;
import com.warung_makan.aneka_rasa.dto.response.LoginResponse;
import com.warung_makan.aneka_rasa.dto.response.RegisterResponse;

public interface AuthService {
    RegisterResponse register(AuthRequest authRequest);
    RegisterResponse registerAdmin(AuthRequest authRequest);
    LoginResponse login(AuthRequest authRequest);
}
