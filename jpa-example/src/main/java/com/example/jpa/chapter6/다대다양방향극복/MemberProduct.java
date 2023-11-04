package com.example.jpa.chapter6.다대다양방향극복;

import javax.persistence.*;

@Entity
@IdClass(MemberProductId.class)
public class MemberProduct {

  @Id
  @ManyToOne
  @JoinColumn(name = "MEMBER_ID")
  private Member member;

  @Id
  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;
}
