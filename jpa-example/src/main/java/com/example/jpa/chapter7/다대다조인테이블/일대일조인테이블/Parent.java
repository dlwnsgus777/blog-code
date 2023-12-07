package com.example.jpa.chapter7.다대다조인테이블.일대일조인테이블;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToMany
  @JoinTable(name = "PARENT_CHILD",
          joinColumns = @JoinColumn(name = "PARNET_ID"),
          inverseJoinColumns = @JoinColumn(name = "CHILD_ID")
  )
  private List<Child> child = new ArrayList<Child>();

}
