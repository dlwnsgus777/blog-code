package com.example.jpa.chapter7.복합키식별;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Parent {

  @Id @Column(name = "PARENT_ID")
  private String id;
  private String name;
}
