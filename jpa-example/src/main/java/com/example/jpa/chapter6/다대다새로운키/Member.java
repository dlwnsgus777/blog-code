package com.example.jpa.chapter6.다대다새로운키;

import com.example.jpa.chapter6.다대다양방향극복.MemberProduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
  @Id @Column(name = "MEMBER_ID")
  private String id;

  private String username;

  @OneToMany(mappedBy = "member")
  private List<Order> orders = new ArrayList<>();
}
