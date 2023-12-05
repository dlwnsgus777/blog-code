package com.example.jpa.chapter7.복합키식별;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

//public class ChildId implements Serializable {
//  private String parent;
//  private String childId;
//
//
//  @Override
//  public boolean equals(final Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    final ChildId childId1 = (ChildId) o;
//
//    if (!Objects.equals(parent, childId1.parent)) return false;
//    return Objects.equals(childId, childId1.childId);
//  }
//
//  @Override
//  public int hashCode() {
//    int result = parent != null ? parent.hashCode() : 0;
//    result = 31 * result + (childId != null ? childId.hashCode() : 0);
//    return result;
//  }
//}


@Embeddable
public class ChildId implements Serializable {
  private String parentId;
  private String childId;

}
