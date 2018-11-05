package com.sportoras.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Embeddable
public class FullName {

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;
}
