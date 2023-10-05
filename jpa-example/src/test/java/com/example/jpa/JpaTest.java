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

    // 비영속 상태 - 객체를 생성한 상태
    Member member = new Member();
    member.setName("test");

    // 영속 상태 - 엔티티 매니저를 통해 영속성 컨텍스트에 저장한 상태
    em.persist(member);

    // 준영속 상태 - 엔티티를 영속성 컨텍스트에서 분리한 상태
    em.detach(member);
    em.close();
    em.clear();

    // 삭제 - 객체를 삭제한 상태
    em.remove(member);
  }
}
