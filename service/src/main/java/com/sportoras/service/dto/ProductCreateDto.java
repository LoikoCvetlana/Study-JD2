package com.sportoras.service.dto;

import com.sportoras.database.entity.Material;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateDto {

    private Long id;
    private String name;
    private String article;
    private String picture;
    private double value;
    private Set<Material> materials = new HashSet<>();
}
