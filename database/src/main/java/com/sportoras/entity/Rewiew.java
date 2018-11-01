package com.sportoras.entity;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor(staticName = "of")
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

    public Rewiew(String text) {
        this.text = text;
    }
}
