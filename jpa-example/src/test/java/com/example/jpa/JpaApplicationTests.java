package com.example.jpa;

import com.example.jpa.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
class JpaApplicationTests {

	@PersistenceContext
	EntityManager em;

	@Test
	@Transactional
	void contextLoads() {
		Member member = new Member();
		em.persist(member);
	}

}
