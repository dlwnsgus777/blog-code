package com.example.jpa.pojo;

public class Member {

  public Member(final String id, final String username) {
    this.id = id;
    this.username = username;
  }

  private String id;
  private String username;

  private Team team;

  public void setTeam(final Team team) {
    this.team = team;
  }

  public Team getTeam() {
    return team;
  }
}
