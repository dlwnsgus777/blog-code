package com.example.jpa.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "members",
uniqueConstraints = {
        @UniqueConstraint(
                name = "NAME_UNIQUE",
                columnNames = {"name"}
        )
})
public class Member {
  public Member() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, length = 10)
  private String name;

  private Integer age;

  @Enumerated(EnumType.STRING)
  private RoleType roleType;

  public enum RoleType {
    ADMIN, USER
  }


  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  @Lob
  private String description;

  public Integer getAge() {
    return age;
  }

  public RoleType getRoleType() {
    return roleType;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public LocalDateTime getLastModifiedDate() {
    return lastModifiedDate;
  }

  public String getDescription() {
    return description;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public void setAge(final Integer age) {
    this.age = age;
  }

  public void setRoleType(final RoleType roleType) {
    this.roleType = roleType;
  }

  public void setCreatedDate(final LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public void setLastModifiedDate(final LocalDateTime lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public void setDescription(final String description) {
    this.description = description;
  }
}
