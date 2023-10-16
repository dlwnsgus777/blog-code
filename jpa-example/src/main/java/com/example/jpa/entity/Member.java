package com.example.jpa.entity;

import javax.persistence.*;

@Entity
public class Member {

  @Id
  @Column(name = "MEMBER_ID")
  private String id;

  private String username;

  // 연관관계 매핑
  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  // 연관관계 설정
  public void setTeam(Team team) {
    this.team = team;
  }

  public Team getTeam() {
    return team;
  }

  public Member(final String id, final String username) {
    this.id = id;
    this.username = username;
  }
}
