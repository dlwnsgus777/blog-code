package com.example.jpa;

import com.example.jpa.entity.Member;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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

  @Test
  @Disabled("스프링의 트랜잭션을 사용해야 테스트 통과됨 - 지금은 내부 연습용으로 트랜잭션을 수동으로 생성한다")
  void entityPersistTest() {
    Member member = new Member();
    member.setName("test");
    EntityTransaction transaction = em.getTransaction();
    // 엔티티 매니저는 데이터 변경 시 트랜잭션을 시작해야한다.
    transaction.begin();

    em.persist(member);

    // 여기까지 INSERT SQL 을 데이터 베이스에 보내지 않는다.

    // 커밋하는 순간 데이터베이스에 INSERT SQL을 보낸다.
    transaction.commit();
  }

  @Test
  @Disabled
  void 변경_감지() {
    EntityTransaction transaction = em.getTransaction();
    transaction.begin();

    Member member = em.find(Member.class, 1L);
    member.setName("test");

    transaction.commit();
  }

  @Test
  void 엔티티_삭제() {
    Member member = em.find(Member.class, 1L);
    // 엔티티 삭제
    em.remove(member);
  }
}
