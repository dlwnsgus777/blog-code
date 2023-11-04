package com.example.jpa.chapter6.일대일단방향;

import javax.persistence.*;

@Entity
public class Member {
  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  private String username;

  @OneToOne
  @JoinColumn(name = "LOCKER_ID")
  private Locker locker;
}
