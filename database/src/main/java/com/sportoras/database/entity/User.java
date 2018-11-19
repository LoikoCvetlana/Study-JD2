package com.sportoras.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "user", schema = "oraz_storage")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Role")
public class User extends BaseEntity<Long> {

    @Embedded
    private FullName fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToOne(mappedBy = "user")
    private UserDateil userDateil;

    public User(String email, String password, FullName fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}