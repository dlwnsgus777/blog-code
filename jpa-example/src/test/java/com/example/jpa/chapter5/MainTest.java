package com.example.jpa.chapter5;

import com.example.jpa.entity.Member;
import com.example.jpa.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
public class MainTest {

  @PersistenceContext
  EntityManager em;

  @Test
  void test1() {
    Member member1 = new Member("member1", "회원1");
    Member member2 = new Member("member2", "회원2");
    Team team = new Team("team1", "팀1");

    member1.setTeam(team);
    member2.setTeam(team);

    Team findTeam = member1.getTeam();
  }

  @Test
  void test2() {
    Team team = new Team("team1", "팀1");
    em.persist(team);

    Member member1 = new Member("member1", "회원1");
    member1.setTeam(team);
    em.persist(member1);

    Member member2 = new Member("member2", "회원2");
    member2.setTeam(team);
    em.persist(member2);
  }

  @Test
  void test3() {
    Team team2 = new Team("team2", "팀2");
    em.persist(team2);

    Member member = em.find(Member.class, "member1");
    member.setTeam(team2);
  }

  @Test
  void test4() {
    Member member1 = em.find(Member.class, "member1");
    member1.setTeam(null); // 연관관계 제거
  }

  @Test
  void test5() {
    Team team1 = new Team("team1", "팀1");
    em.persist(team1);

    Member member1 = new Member("member1", "회원1");

    member1.setTeam(team1);
    team1.getMembers().add(member1);
    em.persist(member1);

    Member member2 = new Member("member2", "회원2");

    member2.setTeam(team1);
    team1.getMembers().add(member2);
    em.persist(member2);
  }
}
