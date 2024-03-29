package com.example.jpa.chapter7.비식별복합키;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

//@Entity
//@IdClass(ParentId.class)
//public class Parent {
//  @Id
//  @Column(name = "PARENT_ID1")
//  private String id1;
//
//  @Id
//  @Column(name = "PARENT_ID2")
//  private String id2;
//}

@Entity
public class Parent {

  @EmbeddedId
  private ParentId id;

  private String name;
}