package com.example.jpa.chapter6.다대다양방향극복;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
  @Id @Column(name = "PRODUCT_ID")
  private String id;
}
