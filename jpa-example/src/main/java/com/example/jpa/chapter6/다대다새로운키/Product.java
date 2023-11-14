package com.example.jpa.chapter6.다대다새로운키;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
  @Id @Column(name = "PRODUCT_ID")
  private String id;
  private String name;
}
