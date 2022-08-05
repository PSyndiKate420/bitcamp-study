package com.bitcamp.board.dao;

import com.bitcamp.board.domain.Board;
import com.bitcamp.util.LinkedList;
import com.bitcamp.util.List;

// 게시글 목록을 관리하는 역할
//
public class BoardDao {

  List<Board> list = new LinkedList<>();

  private int boardNo = 0;

  public void insert(Board board) {
    board.no = nextNo();
    list.add(board);
  }

  public Board findByNo(int boardNo) {
    for (int i = 0; i < list.size(); i++) {
      Board board = list.get(i);
      if (board.no == boardNo) {
        return board;
      }
    }
    return null;
  }

  public boolean delete(int boardNo) {
    for (int i = 0; i < list.size(); i++) {
      Board board = list.get(i);
      if (board.no == boardNo) {
        return list.remove(i) != null;
      }
    }
    return false;
  }

  public Board[] findAll() {
    Board[] arr = list.toArray(new Board[0]);

    // 배열을 역순으로 정리한 뒤 리턴
    Board[] arr2 = new Board[arr.length];
    for(int i= 0; i<arr2.length; i++) {
      arr[i] = arr[arr.length-i -1];
    }
    return arr2; 
  }

  private int nextNo() {
    return ++boardNo;
  }
}














