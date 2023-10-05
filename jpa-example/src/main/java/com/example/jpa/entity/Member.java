package com.example.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {
  public Member() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }
}
