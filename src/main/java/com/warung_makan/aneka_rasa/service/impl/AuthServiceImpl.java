package com.warung_makan.aneka_rasa.service.impl;

import com.warung_makan.aneka_rasa.constant.UserRole;
import com.warung_makan.aneka_rasa.dto.request.AuthRequest;
import com.warung_makan.aneka_rasa.dto.response.LoginResponse;
import com.warung_makan.aneka_rasa.dto.response.RegisterResponse;
import com.warung_makan.aneka_rasa.entity.UserAccount;
import com.warung_makan.aneka_rasa.repository.UserRepository;
import com.warung_makan.aneka_rasa.service.AuthService;
import com.warung_makan.aneka_rasa.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public RegisterResponse register(AuthRequest authRequest) {
        if (userRepository.findByUsername(authRequest.getUsername()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username is already exist");
        }

        UserAccount userAccount = UserAccount.builder()
                .username(authRequest.getUsername())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .role(UserRole.CUSTOMER)
                .build();

        userRepository.saveAndFlush(userAccount);

        return RegisterResponse.builder()
                .username(userAccount.getUsername())
                .role(String.valueOf(userAccount.getRole()))
                .build();
    }

    @Override
    public RegisterResponse registerAdmin(AuthRequest authRequest) {
        return null;
    }

    @Override
    public LoginResponse login(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                usernamePasswordAuthenticationToken
        );

        UserAccount userAccount = (UserAccount) authentication.getPrincipal();

        String generatedToken = jwtService.generateToken(userAccount);

        return LoginResponse.builder()
                .username(userAccount.getUsername())
                .token(generatedToken)
                .roles(String.valueOf(userAccount.getRole()))
                .build();
    }
}
