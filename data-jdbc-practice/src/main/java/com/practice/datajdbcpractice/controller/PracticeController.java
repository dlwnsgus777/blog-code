package com.practice.datajdbcpractice.controller;


import com.practice.datajdbcpractice.domain.Brands;
import com.practice.datajdbcpractice.domain.BrandsDto;
import com.practice.datajdbcpractice.domain.Categores;
import com.practice.datajdbcpractice.domain.CategoresDto;
import com.practice.datajdbcpractice.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {

    @Autowired
    private PracticeService practiceService;

    @GetMapping("/brands")
    public ResponseEntity<Iterable<Brands>> getBrands() {
        Iterable<Brands> brandList = practiceService.getBrands();
        return ResponseEntity.ok().body(brandList);
    }

    @PostMapping("/brands")
    public BrandsDto postBrand(@RequestBody BrandsDto brandsDto) {
        Brands brands = practiceService.createBrands(brandsDto);
        return BrandsDto.of(brands.getBrandName());
    }

    @GetMapping("/categores")
    public ResponseEntity<Iterable<Categores>> getCategores() {
        Iterable<Categores> categores = practiceService.getCategores();
        return ResponseEntity.ok().body(categores);
    }

    @PostMapping("/categores")
    public CategoresDto postCategory(@RequestBody CategoresDto categoresDto) {
        Categores categores = practiceService.createCategores(categoresDto);
        return CategoresDto.of(categores.getCategoryName());
    }
}
