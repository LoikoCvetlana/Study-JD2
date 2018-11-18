package com.sportoras.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@ToString(exclude = {"rewiew"})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@DiscriminatorValue("Users")
public class Client extends User {

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public Client(String email, String password, LocalDate registrationDate, FullName fullName) {
        super(email, password, fullName);
        this.registrationDate = registrationDate;

    }
}
