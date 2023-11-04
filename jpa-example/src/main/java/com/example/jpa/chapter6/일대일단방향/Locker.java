package com.example.jpa.chapter6.일대일단방향;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Locker {
  @Id
  @GeneratedValue
  @Column(name = "LOCKER_ID")
  private Long id;

  private String name;
}
