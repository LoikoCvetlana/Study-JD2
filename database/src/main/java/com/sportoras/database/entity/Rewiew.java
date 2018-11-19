package com.sportoras.database.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = "user")
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rewiew", schema = "oraz_storage")
public class Rewiew extends BaseEntity<Long> {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String text;

    private LocalDate date;

    public Rewiew(User user, String text, LocalDate date) {
        this.user = user;
        this.text = text;
        this.date = date;
    }
}
