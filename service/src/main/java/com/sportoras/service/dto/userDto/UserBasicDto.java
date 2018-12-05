package com.sportoras.service.dto.userDto;

import com.sportoras.database.entity.FullName;
import com.sportoras.database.entity.UserDateil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBasicDto {

    private Long id;
    private FullName fullName;
    private String Role;
    private UserDateil userDateil;
}
