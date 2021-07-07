package com.practice.datajdbcpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BrandsDto {
    private Integer idx;
    private String brandName;

    public static BrandsDto of(String brandName) {
        return BrandsDto.builder().brandName(brandName).build();
    }

    public static Brands convert(BrandsDto brandsDto) {
        return Brands.convertDto(brandsDto);
    }
}
