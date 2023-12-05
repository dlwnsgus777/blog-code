package com.example.jpa.chapter7.복합키식별;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

//@Entity
//@IdClass(ChildId.class)
//public class Child {
//  @Id
//  @ManyToOne
//  @JoinColumn(name = "PARENT_ID")
//  public Parent parent;
//
//  @Id
//  @Column(name = "CHILD_ID")
//  private String childId;
//}


@Entity
@IdClass(ChildId.class)
public class Child {

  @EmbeddedId
  public ChildId id;

  @MapsId("parentId")
  @ManyToOne
  @JoinColumn(name = "PARENT_ID")
  public Parent parent;

  @Id
  @Column(name = "CHILD_ID")
  private String childId;
}
