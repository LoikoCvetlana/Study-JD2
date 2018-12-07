package com.sportoras.service.service;

import com.sportoras.database.entity.Client;
import com.sportoras.database.entity.User;
import com.sportoras.database.entity.UserDateil;
import com.sportoras.database.repository.UserDateilRepository;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.dto.userDto.UserBasicDto;
import com.sportoras.service.dto.userDto.UserCreateDto;
import com.sportoras.service.dto.userDto.UserDetailCreateDto;
import com.sportoras.service.dto.userDto.UserDetailDto;
import com.sportoras.service.dto.userDto.UserFullDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailService {

    private final UserDateilRepository userDateilRepository;


    @Transactional
    public UserDetailDto saveUser(UserDetailCreateDto userDetailCreateDto) {
        UserDateil sevedUserDetail = userDateilRepository.save(
                UserDateil.builder()
                        .company(userDetailCreateDto.getCompany())
                        .phone(userDetailCreateDto.getPhone())
                        .otherInformation(userDetailCreateDto.getOtherInformation())
                        .build());

        return UserDetailDto.builder()
                .id(sevedUserDetail.getId())
                .company(sevedUserDetail.getCompany())
                .phone(sevedUserDetail.getPhone())
                .otherInformation(sevedUserDetail.getOtherInformation())
                .build();
    }
}