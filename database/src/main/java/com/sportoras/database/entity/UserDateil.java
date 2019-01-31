package com.sportoras.database.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@ToString(exclude = "user")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@Entity
@javax.persistence.Table(name = "user_dateil", schema = "oraz_storage")
public class UserDateil extends BaseEntity<Long> {

    private String company;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "personal_phone")
    private String personalPhone;

    @Column(name = "other_information")
    private String otherInformation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserDateil(String company, String workPhone, User user) {
        this.company = company;
        this.workPhone = workPhone;
    }

    public UserDateil(String company, String workPhone, String personalPhone, String otherInformation, User user) {
        this.company = company;
        this.workPhone = workPhone;
        this.personalPhone = personalPhone;
        this.otherInformation = otherInformation;
        this.user = user;
    }
}
