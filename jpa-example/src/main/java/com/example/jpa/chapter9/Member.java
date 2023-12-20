package com.example.jpa.chapter9;

import javax.persistence.*;

@Entity
public class Member {
  @Id
  private Long id;
  private String username;

  @Embedded
  Address homeAddress;

  @Embedded
  @AttributeOverrides({
    @AttributeOverride(name = "city", column = @Column(name = "COMPANY_CITY"))
  })
  Address companyAddress;
}
