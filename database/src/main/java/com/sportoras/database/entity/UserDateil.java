package com.sportoras.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
@AllArgsConstructor
@javax.persistence.Table(name = "user_dateil", schema = "oraz_storage")
public class UserDateil extends BaseEntity<Long> {

    @Column(name = "company")
    private String company;

    @Column(name = "phone")
    private String phone;

    @Column(name = "other_information")
    private String otherInformation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserDateil(String company, String workPhone, User user) {
        this.company = company;
        this.phone =phone;
    }

    public UserDateil(String company, String workPhone, String personalPhone, String otherInformation, User user) {
        this.company = company;
        this.phone =phone;
        this.otherInformation = otherInformation;
        this.user = user;
    }
}
