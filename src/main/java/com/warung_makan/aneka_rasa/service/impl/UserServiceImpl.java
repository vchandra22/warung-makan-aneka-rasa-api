package com.warung_makan.aneka_rasa.service.impl;

import com.warung_makan.aneka_rasa.entity.UserAccount;
import com.warung_makan.aneka_rasa.repository.UserRepository;
import com.warung_makan.aneka_rasa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserAccount getByUserId(String id) {
        return null;
    }

    @Override
    public UserAccount getByContext() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> userAccount = userRepository.findByUsername(username);
        System.out.println(userAccount);

        return userAccount.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
    }
}
