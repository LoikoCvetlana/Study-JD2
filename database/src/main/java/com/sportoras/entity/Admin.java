package com.sportoras.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@DiscriminatorValue("Admins")
public class Admin extends User {

    private String position;

    public Admin(String email, String password, String position, FullName fullName) {
        super(email, password, fullName);
        this.position = position;
    }
}
