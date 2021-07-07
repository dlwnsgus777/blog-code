package com.practice.datajdbcpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoresDto {
    private Integer idx;
    private String categoryName;

    public static CategoresDto of(String brandName) {
        return CategoresDto.builder().categoryName(brandName).build();
    }

    public static Categores convert(CategoresDto categoresDto) {

        return Categores.convertDto(categoresDto);
    }
}
