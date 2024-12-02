package com.warung_makan.aneka_rasa.service;

import com.warung_makan.aneka_rasa.dto.response.JwtClaims;
import com.warung_makan.aneka_rasa.entity.UserAccount;

public interface JwtService {
    String generateToken(UserAccount userAccount);
    boolean verifyJwtToken(String token);
    JwtClaims getClaimsByToken(String token);
}
