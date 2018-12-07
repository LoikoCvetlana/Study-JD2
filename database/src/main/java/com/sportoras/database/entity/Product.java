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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString(exclude = "material")
@Data
@EqualsAndHashCode(of = "id")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product", schema = "oraz_storage")
public class Product extends BaseEntity<Long> {

    private String name;

    @Column(name = "article", unique = true)
    private String article;

    private String picture;

    private BigDecimal value;

    @ManyToMany
    @JoinTable(name = "product_material", schema = "oraz_storage",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<Material> materials = new ArrayList<>();

    public void addMaterial(Material material) {
        this.materials.add(material);
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, String article, String picture, BigDecimal value) {
        this.name = name;
        this.article = article;
        this.picture = picture;
        this.value = value;
    }
}
