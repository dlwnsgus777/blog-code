package com.example.jpa;

import com.example.jpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class JpaTest {

  @PersistenceContext
  EntityManager em;

  @Test
  @Transactional
  void jpaTest() {
    Member member = new Member();
    em.persist(member);
  }
}
