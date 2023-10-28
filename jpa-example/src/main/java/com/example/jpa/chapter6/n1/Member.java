package com.example.jpa.chapter6.n1;

import javax.persistence.*;

@Entity
public class Member {

  @Id @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  private String  username;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;
}
