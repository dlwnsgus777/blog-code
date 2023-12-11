package com.example.jpa.chapter8;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Member {

  @Id
  private Long id;

  private String username;

  @ManyToOne
  private Team team;
}
