package com.sportoras.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private Role role;
    private String name;
    private String password;
    private String lastname;
    private LocalDate registrationDate;
    private String email;
    private String organization;
    private String otherInformation;

}
