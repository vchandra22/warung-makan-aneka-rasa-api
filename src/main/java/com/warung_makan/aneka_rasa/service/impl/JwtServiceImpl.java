package com.warung_makan.aneka_rasa.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.warung_makan.aneka_rasa.constant.Constant;
import com.warung_makan.aneka_rasa.dto.response.JwtClaims;
import com.warung_makan.aneka_rasa.entity.UserAccount;
import com.warung_makan.aneka_rasa.service.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@Service
public class JwtServiceImpl implements JwtService {
    private final String JWT_SECRET;
    private final Long JWT_EXPIRATION;
    private final String ISSUER;
    private final Algorithm algorithm;

    public JwtServiceImpl(
           @Value("${aneka_rasa.jwt.secret_key}") String jwtSecret,
           @Value("${aneka_rasa.jwt.expirationInSecond}") Long jwtExpiration,
           @Value("${aneka_rasa.jwt.issuer}") String issuer
    ) {
        JWT_SECRET = jwtSecret;
        JWT_EXPIRATION = jwtExpiration;
        ISSUER = issuer;
        algorithm = Algorithm.HMAC512(jwtSecret);
    }

    @Override
    public String generateToken(UserAccount userAccount) {
        try {
            return JWT.create()
                    .withSubject(userAccount.getId())
                    .withIssuedAt(Instant.now())
                    .withExpiresAt(Instant.now().plusSeconds(JWT_EXPIRATION))
                    .withClaim("roles", userAccount
                            .getAuthorities()
                            .stream()
                            .map(GrantedAuthority::getAuthority).toList())
                    .withIssuer(ISSUER)
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, Constant.ERROR_CREATING_JWT);
        }
    }

    @Override
    public boolean verifyJwtToken(String token) {
        return false;
    }

    @Override
    public JwtClaims getClaimsByToken(String token) {
        return null;
    }
}
