package com.example.jpa.chapter7.다대다조인테이블.일대일조인테이블;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Child {

  @Id
  @GeneratedValue
  @Column(name = "CHILD_ID")
  private Long id;

}
