package com.sportoras.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDtoFilter {

    private String productName;
    private double minValue;
    private double maxValue;
    private Pageable pageable;
}