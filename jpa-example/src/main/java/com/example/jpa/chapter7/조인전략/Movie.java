package com.example.jpa.chapter7.조인전략;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item{
  private String director;
  private String actor;
}
