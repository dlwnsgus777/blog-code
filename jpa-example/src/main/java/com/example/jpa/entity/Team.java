package com.example.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

  @Id
  @Column(name = "TEAM_ID")
  private String id;

  private String name;

  // 추가
  @OneToMany(mappedBy = "team")
  private List<Member> members = new ArrayList<>();

  public Team(final String id, final String name) {
    this.id = id;
    this.name = name;
  }

  public List<Member> getMembers() {
    return members;
  }

  public Team() {

  }
}
