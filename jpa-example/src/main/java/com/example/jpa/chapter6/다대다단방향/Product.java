package com.example.jpa.chapter6.다대다단방향;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
  @Id @Column(name = "PRODUCT_ID")
  private String id;
}
