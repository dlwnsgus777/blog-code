package com.example.jpa.chapter6.일대일양방향.대상테이블외래키;

import javax.persistence.*;

@Entity
public class Locker {
  @Id
  @GeneratedValue
  @Column(name = "LOCKER_ID")
  private Long id;

  @OneToOne
  @JoinColumn(name = "MEMBER_ID")
  private Member member;

  private String name;
}
