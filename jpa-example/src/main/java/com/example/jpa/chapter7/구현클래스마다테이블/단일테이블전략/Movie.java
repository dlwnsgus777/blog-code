package com.example.jpa.chapter7.구현클래스마다테이블.단일테이블전략;

import com.example.jpa.chapter7.조인전략.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {
  private String director;
  private String actor;
}
