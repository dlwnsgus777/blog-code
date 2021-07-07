package com.practice.datajdbcpractice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Table("categores")
@Data
public class Categores {
    @Id
    private Integer idx;
    @Column("category_name")
    private String categoryName;

    @MappedCollection(idColumn = "category_idx")
    private Set<BrandCategory> brandCategories = new HashSet<>();

    public static Categores convertDto(CategoresDto categoresDto) {
        Categores categores = new Categores();
        categores.setCategoryName(categoresDto.getCategoryName());
        return categores;
    }
}
