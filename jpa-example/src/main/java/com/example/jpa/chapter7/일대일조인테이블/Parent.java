package com.example.jpa.chapter7.일대일조인테이블;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Parent {

  @Id
  @GeneratedValue
  private Long id;

  @OneToOne
  @JoinTable(name = "PARENT_CHILD",
          joinColumns = @JoinColumn(name = "PARNET_ID"),
          inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
  )
  private Child child;
}
