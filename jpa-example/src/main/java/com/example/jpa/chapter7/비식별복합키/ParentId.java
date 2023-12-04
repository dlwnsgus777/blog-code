package com.example.jpa.chapter7.비식별복합키;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.Objects;

//public class ParentId implements Serializable {
//  private String id;
//  private String id2;
//
//  @Override
//  public boolean equals(final Object o) {
//    if (this == o) return true;
//    if (o == null || getClass() != o.getClass()) return false;
//
//    final ParentId parentId = (ParentId) o;
//
//    if (!Objects.equals(id, parentId.id)) return false;
//    return Objects.equals(id2, parentId.id2);
//  }
//
//  @Override
//  public int hashCode() {
//    int result = id != null ? id.hashCode() : 0;
//    result = 31 * result + (id2 != null ? id2.hashCode() : 0);
//    return result;
//  }
//}

@Embeddable
public class ParentId implements Serializable {

  @Column(name = "PARENT_ID1")
  private String id;

  @Column(name = "PARENT_ID2")
  private String id2;

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    final ParentId parentId = (ParentId) o;

    if (!Objects.equals(id, parentId.id)) return false;
    return Objects.equals(id2, parentId.id2);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id2 != null ? id2.hashCode() : 0);
    return result;
  }
}

