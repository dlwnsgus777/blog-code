package com.example.jpa.chapter6.다대다양방향극복;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
  @Id @Column(name = "MEMBER_ID")
  private String id;

  private String username;

  @OneToMany(mappedBy = "member")
  private List<MemberProduct> memberProducts;

}
