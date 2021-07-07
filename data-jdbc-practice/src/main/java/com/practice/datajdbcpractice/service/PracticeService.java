package com.practice.datajdbcpractice.service;

import com.practice.datajdbcpractice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {

    @Autowired
    private BrandsRepository brandsRepository;

    @Autowired
    private CategoresRepository categoresRepository;

    public Iterable<Brands> getBrands() {
        Iterable<Brands> brandsList = brandsRepository.findAll();

        return brandsList;
    }

    public Brands createBrands(BrandsDto brandsDto) {
        System.out.println(brandsDto.toString());
        Brands brands = brandsRepository.save(Brands.convertDto(brandsDto));
        return brands;
    }

    public Iterable<Categores> getCategores() {
        Iterable<Categores> categores = categoresRepository.findAll();

        return categores;
    }

    public Categores createCategores(CategoresDto categoresDto) {
        System.out.println(categoresDto.toString());
        Categores categores = categoresRepository.save(Categores.convertDto(categoresDto));
        return categores;
    }
}
