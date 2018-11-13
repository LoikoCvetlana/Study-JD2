package com.sportoras.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = "product")
@Data
@Builder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Entity
@Table(name = "material", schema = "oraz_storage")
public class Material extends BaseEntity<Long> {

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    private String description;

    private Boolean availability;

    @ManyToMany
    @JoinTable(name = "product_material", schema = "oraz_storage",
            joinColumns = @JoinColumn(name = "material_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

    public Material(String name, String description, Boolean availability) {
        this.name = name;
        this.description = description;
        this.availability = availability;
    }
}

