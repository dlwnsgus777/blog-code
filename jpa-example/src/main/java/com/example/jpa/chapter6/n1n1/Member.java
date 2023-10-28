package com.example.jpa.chapter6.n1n1;


import javax.persistence.*;

@Entity
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "MEMBER_ID")
  private Long id;

  private String  username;

  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;

  public void setTeam(Team team) {
    this.team = team;

    //무한 루프에 빠지지 않도록 체크
    if (!team.getMembers().contains(this)) {
      team.getMembers().add(this);
    }
  }

  public Team getTeam() {
    return team;
  }
}
