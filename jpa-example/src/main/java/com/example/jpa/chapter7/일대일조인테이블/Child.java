package com.example.jpa.chapter7.일대일조인테이블;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Child {

  @Id
  @GeneratedValue
  @Column(name = "CHILD_ID")
  private Long id;

}
