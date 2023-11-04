package com.example.jpa.chapter6.다대다양방향극복;

import java.io.Serializable;
import java.util.Objects;

public class MemberProductId implements Serializable {
  private String member;
  private String product;

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final MemberProductId that = (MemberProductId) o;
    return Objects.equals(member, that.member) && Objects.equals(product, that.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(member, product);
  }
}
