package com.example.jpa.chapter6.일대다단방향;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

  @Id @GeneratedValue
  @Column(name = "TEAM_ID")
  private Long id;

  private String name;

  @OneToMany
  @JoinColumn(name = "TEAM_ID")
  private List<Member> members = new ArrayList<>();

}
