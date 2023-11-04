package com.example.jpa.chapter6.일대일양방향.대상테이블외래키;

import javax.persistence.*;

@Entity
public class Member {
  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  private String username;

  @OneToOne(mappedBy = "member")
  private Locker locker;
}
