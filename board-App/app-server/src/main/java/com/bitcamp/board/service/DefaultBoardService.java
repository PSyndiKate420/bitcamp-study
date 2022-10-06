package com.bitcamp.board.service;

import java.sql.Connection;
import java.util.List;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;


public class DefaultBoardService implements BoardService {
  Connection con; // 트랜잭션을 실행하기 위한 객체 생성
  BoardDao boardDao; // BoardDao 객체 생성

  public DefaultBoardService(BoardDao boardDao, Connection con) {
    this.boardDao = boardDao; // set BoardDao
    this.con = con;
  }

  /* 게시글을 추가하는 기능*/
  @Override
  public void add(Board board) throws Exception {
    con.setAutoCommit(false);
    try {
      // 1) 게시글 등록
      if (boardDao.insert(board) == 0) {
        throw new Exception("게시글 등록 실패!");
      }
      // 2) 첨부파일 등록
      boardDao.insertFiles(board);
      con.commit();
    } catch(Exception e) {
      con.rollback();
      throw e;
    } finally {
      con.setAutoCommit(true);
    }
  }

  /* 업데이트를 진행하는 기능*/
  @Override
  public boolean update(Board board) throws Exception {
    con.setAutoCommit(false);
    try {
      // 1) 게시글 변경
      if (boardDao.update(board) == 0) {
        return false;
      }
      // 2) 첨부파일 추가
      boardDao.insertFiles(board);

      con.commit();
      return true;
    } catch (Exception e) {
      con.rollback();
      throw e;
    } finally {
      con.setAutoCommit(true);
    }
  }

  @Override
  public Board get(int no) throws Exception {
    /* 이 메소드는 하는 일이 없지만 일관성을 위해서 입력
     * 즉, Controller는 Service 객체를 사용하고
     * Service객체는 DAO구조를 사용하는 구조*/
    return boardDao.findByNo(no);
  }

  @Override
  public boolean delete(int no) throws Exception {
    con.setAutoCommit(false);
    try {
      // 1) 첨부파일 삭제
      boardDao.deleteFiles(no);

      // 2) 게시글 삭제
      boolean result =  boardDao.delete(no) > 0;
      con.commit();
      return result;
    } catch (Exception e) {
      con.rollback();
      throw e;
    } finally {
      con.setAutoCommit(true);
    }
  }

  /* 이 메소드는 하는 일이 없지만 일관성을 위해서 입력
   * 즉, Controller는 Service 객체를 사용하고
   * Service객체는 DAO구조를 사용하는 구조*/
  @Override
  public List<Board> list() throws Exception {
    return boardDao.findAll();
  }

  @Override
  public AttachedFile getAttachedFile(int fileNo) throws Exception {
    return boardDao.findFileByNo(fileNo);
  }

  @Override
  public boolean deleteAttachedFile(int fileNo) throws Exception {
    return boardDao.deleteFile(fileNo) > 0;
  }


}
