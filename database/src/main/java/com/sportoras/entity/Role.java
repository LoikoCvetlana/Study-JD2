package com.sportoras.entity;

import lombok.Getter;

@Getter
public enum Role {
    USER("Пользователь"),
    ADMIN("Администратор");

    private String description;

    Role(String description) {
        this.description = description;
    }

}
