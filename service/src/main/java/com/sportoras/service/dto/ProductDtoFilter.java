package com.sportoras.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDtoFilter {

    private String productName;
    private Double value;
    private int limit;
    private int offset;
}
