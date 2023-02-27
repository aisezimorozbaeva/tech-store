package com.ais.techstore.service.impl;

import com.ais.techstore.model.User;
import com.ais.techstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(s).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("user does not exist");
        }
        return new UserDetailsImpl(user);
    }
}
