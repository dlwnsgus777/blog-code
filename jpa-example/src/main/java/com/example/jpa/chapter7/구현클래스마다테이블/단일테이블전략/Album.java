package com.example.jpa.chapter7.구현클래스마다테이블.단일테이블전략;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
  private String artist;
}
