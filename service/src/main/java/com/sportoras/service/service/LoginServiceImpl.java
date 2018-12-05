package com.sportoras.service.service;

import com.sportoras.database.entity.User;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.converter.UserDetailsConverter;
import com.sportoras.service.dto.userDto.UserBasicDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginServiceImpl implements LoginService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserDetailsConverter detailsConverter;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(detailsConverter::convert)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }



}