package com.sportoras.service.service;

import com.sportoras.database.entity.User;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.converter.UserDetailsConverter;
import com.sportoras.service.dto.productDto.ProductFullDto;
import com.sportoras.service.dto.userDto.UserBasicDto;
import com.sportoras.service.dto.userDto.UserCreateDto;
import com.sportoras.service.dto.userDto.UserFullDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;

    public User findUserById(Long productId) {
        return userRepository.findUserById(productId);
    }

    public List<UserBasicDto> allUsers() {
        return userRepository.findAll().stream()
                .map(it -> new UserBasicDto(it.getId(), it.getFullName(), it.getRole(), it.getUserDateil(),it.getRegistrationDate()))
                .collect(Collectors.toList());
    }

    @Transactional
    public UserFullDto saveUser(UserCreateDto userCreateDto) {
        User sevedUser = userRepository.save(
                User.builder()
                        .fullName(userCreateDto.getFullName())
                        .email(userCreateDto.getEmail())
                        .password(userCreateDto.getPassword())
                        .userDateil(userCreateDto.getUserDateil())
                        .build());

        return UserFullDto.builder()
                .id(sevedUser.getId())
                .fullName(sevedUser.getFullName())
                .email(sevedUser.getEmail())
                .password(sevedUser.getPassword())
                .userDateil(sevedUser.getUserDateil())
                .registrationDate(LocalDate.now())
                .build();
    }
}