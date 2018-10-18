package com.sportoras.service;

import com.sportoras.dao.UserDao;
import com.sportoras.dto.UserFullDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {

    private static final UserService INSTANCE = new UserService();

    public UserFullDto findById(Long userId) {
        return UserDao.getInstance().findById(userId)
                .map(it -> UserFullDto.builder()
                        .id(it.getId())
                        .role(it.getRole().getDescription())
                        .name(it.getName())
                        .lastname(it.getLastname())
                        .registrationDate(it.getRegistrationDate())
                        .email(it.getEmail())
                        .organization(it.getOrganization())
                        .otherInformation(it.getOtherInformation())
                        .build())
                .orElse(null);
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
