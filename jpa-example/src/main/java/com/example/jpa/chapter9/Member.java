package com.example.jpa.chapter9;

import javax.persistence.*;
import java.util.HashSet;

@Entity
public class Member {
  @Id
  private Long id;
  private String username;

  @Embedded
  Address homeAddress;

  @ElementCollection
  @CollectionTable(name = "FAVORITE_FOODS",
    joinColumns = @JoinColumn(name = "MEMBER_ID")
  )
  @Column(name = "FOOD_NAME")
  private set<String> favoriteFoods = new HashSet<String>();
}
