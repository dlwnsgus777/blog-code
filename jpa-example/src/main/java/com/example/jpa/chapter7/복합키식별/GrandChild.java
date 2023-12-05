package com.example.jpa.chapter7.복합키식별;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

//@Entity
//@IdClass(GrandChildId.class)
//public class GrandChild {
//
//  @Id
//  @ManyToOne
//  @JoinColumns({
//          @JoinColumn(name = "PARENT_ID"),
//          @JoinColumn(name = "CHILD_ID")
//  })
//  private Child child;
//
//  @Id @Column(name = "GRANDCHILD_ID")
//  private String id;
//}

@Entity
public class GrandChild {

  @EmbeddedId
  private GrandChildId id;

  @MapsId("childId")
  @ManyToOne
  @JoinColumns({
          @JoinColumn(name = "PARENT_ID"),
          @JoinColumn(name = "CHILD_ID")
  })
  public Child child;
}