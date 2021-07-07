package com.practice.datajdbcpractice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("brands")
@Data
public class Brands {
    @Id
    private Integer idx;
    @Column("brand_name")
    private String brandName;

    public static Brands convertDto(BrandsDto brandsDto) {
        Brands brands = new Brands();
        brands.setBrandName(brandsDto.getBrandName());
        return brands;
    }
}
