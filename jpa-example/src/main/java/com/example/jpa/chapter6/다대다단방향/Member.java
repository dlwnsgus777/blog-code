package com.example.jpa.chapter6.다대다단방향;

import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
  @Id @Column(name = "MEMBER_ID")
  private String id;

  private String username;

  @ManyToMany
  @JoinTable(name = "MEMBER_PRODUCT",
      joinColumns = @JoinColumn(name = "MEMBER_ID"),
      inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID")
  )
  private List<Product> products = new ArrayList<Product>();

}
