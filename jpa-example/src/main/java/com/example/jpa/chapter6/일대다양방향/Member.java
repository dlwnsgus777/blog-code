package com.example.jpa.chapter6.일대다양방향;

import javax.persistence.*;

@Entity
public class Member {

  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  private String username;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
  private Team team;
}
