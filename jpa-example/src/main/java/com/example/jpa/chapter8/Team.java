package com.example.jpa.chapter8;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
  @Id
  private Long id;

  public String name;
}
