package com.sportoras.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@ToString(exclude = {"rewiew"})
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@DiscriminatorValue("Пользователь")
public class Client extends User {

    @OneToOne(mappedBy = "client")
    private UserDateil userDateil;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    public Client(String email, String password, LocalDate registrationDate, FullName of) {
        super(email, password, of);
        this.registrationDate = registrationDate;

    }
}
