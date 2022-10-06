package com.bitcamp.board.service;

import java.util.List;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.domain.Member;

/* 비즈니스 로직을 수행하는 객체
 * - 메소드 이름은 업무와 관련된 이름을 사용하자 */
public class DefaultMemberService implements MemberService {
  MemberDao memberDao; // MemberDao 객체 생성

  public DefaultMemberService(MemberDao memberDao) {
    this.memberDao = memberDao; // set MemberDao
  }

  /* 게시글을 추가하는 기능*/
  @Override
  public void add(Member member) throws Exception {
    memberDao.insert(member);
  }

  /* 업데이트를 진행하는 기능*/
  @Override
  public boolean update(Member member) throws Exception {
    return memberDao.update(member) > 0;
  }

  @Override
  public Member get(int no) throws Exception {
    return memberDao.findByNo(no);
  }

  @Override
  public Member get(String email, String password) throws Exception {
    return memberDao.findByEmailPassword(email, password);
  }

  @Override
  public boolean delete(int no) throws Exception {
    return memberDao.delete(no) > 0;
  }

  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }
}
