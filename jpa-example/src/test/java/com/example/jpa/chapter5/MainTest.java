package com.example.jpa.chapter5;

import com.example.jpa.pojo.Member;
import com.example.jpa.pojo.Team;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  void test1() {
    Member member1 = new Member("member1", "회원1");
    Member member2 = new Member("member2", "회원2");
    Team team = new Team("team1", "팀1");

    member1.setTeam(team);
    member2.setTeam(team);

    Team findTeam = member1.getTeam();
  }
}
