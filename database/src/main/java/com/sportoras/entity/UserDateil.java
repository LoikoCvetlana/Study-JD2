package com.sportoras.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@ToString(exclude = "user")
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@javax.persistence.Table(name = "user_dateil", schema = "oraz_storage")
public class UserDateil {

    @Id
    @Column(name = "user_id")
    private Long id;

    private String company;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "personal_phone")
    private String personalPhone;

    @Column(name = "other_information")
    private String otherInformation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Client client;

    public UserDateil(String company, String workPhone, long client) {
        this.company = company;
        this.workPhone = workPhone;
    }
}
