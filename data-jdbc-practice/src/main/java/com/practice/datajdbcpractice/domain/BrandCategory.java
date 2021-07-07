package com.practice.datajdbcpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("brand_category")
@Data
@AllArgsConstructor
public class BrandCategory {
    Long brandIdx;
}
