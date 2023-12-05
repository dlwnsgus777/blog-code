package com.example.jpa.chapter7.복합키식별;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//public class GrandChildId implements Serializable {
//  private ChildId child;
//  private String id;
//
//  @Override
//  public boolean equals(final Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    final GrandChildId that = (GrandChildId) o;
//
//    if (!Objects.equals(child, that.child)) return false;
//    return Objects.equals(id, that.id);
//  }
//
//  @Override
//  public int hashCode() {
//    int result = child != null ? child.hashCode() : 0;
//    result = 31 * result + (id != null ? id.hashCode() : 0);
//    return result;
//  }
//}

@Embeddable
public class GrandChildId implements Serializable {
  private ChildId child;

  @Column(name = "GRANDCHILD_ID")
  private String id;


  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    final GrandChildId that = (GrandChildId) o;

    if (!Objects.equals(child, that.child)) return false;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    int result = child != null ? child.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    return result;
  }
}