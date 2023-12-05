package com.example.jpa.chapter7.비식별관계;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GrandChild {

  @Id @GeneratedValue
  @Column(name = "GRANDCHILD_ID")
  private Long id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "CHILD_ID")
  private Child child;
}
