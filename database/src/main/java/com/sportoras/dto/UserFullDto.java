package com.sportoras.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFullDto {

    private Long id;
    private String role;
    private String name;
    private String lastname;
    private LocalDate registrationDate;
    private String email;
    private String organization;
    private String otherInformation;
}
