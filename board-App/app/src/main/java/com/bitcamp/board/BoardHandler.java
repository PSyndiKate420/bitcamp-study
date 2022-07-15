/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board;

public class BoardHandler {

  // Board 인스턴스의 주소를 저장할 레퍼런스 배열을 만든다.
  static final int SIZE = 3;
  static Board[] boards = new Board[SIZE];

  static int boardCount = 0;

  static void processList() {
    System.out.println("[게시글 목록]");
    System.out.println("번호 제목 조회수 작성자 등록일");

    for(int i = 0; i < boardCount; i++) {
      Board board = boards[i];
      java.util.Date date = new java.util.Date(board.createdDated);

      // 날짜 정보에서 값을 추출하여 특정 포맷의 문자열로 만들어줄 도구를 준비 
      java.text.SimpleDateFormat df =
          new java.text.SimpleDateFormat("yyyy-MM-dd");
      String dateStr = df.format(date);

      System.out.printf("%d\t%s\t%d\t%s\t%s\n",
          board.no, board.title, board.viewCount, board.writer, dateStr);
    }
  }

  static void processDetail() {
    System.out.println("[게시글 상세보기]");

    int boardNo = Prompt.inputInt("조회할 게시글 번호? ");

    Board board = null;
    for (int i=0; i< boardCount; i++) {
      if (boards[i].no == boardNo) {
        board = boards[i];
        break;
      }
    }

    // 사용자가 입력한 번호에 해당하는 게시글을 못찾았다면
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    System.out.printf("번호 : %d\n", board.no);  
    System.out.printf("제목 : %s\n", board.title);
    System.out.printf("내용 : %s\n", board.content);
    System.out.printf("조회수 : %d\n", board.viewCount);
    System.out.printf("작성자 : %s\n", board.writer);
    java.util.Date date = new java.util.Date(board.createdDated);
    System.out.printf("등록일 : %tY-%1$tm-%1$td\n", date);
  }

  static void processInput() {
    System.out.println("[게시글 등록]");

    // 배열의 크기를 초과하지 않았는지 검사한다.
    if (boardCount == SIZE) {
      System.out.println("게시글의 최대 개수를 초과했습니다!");
      return;
    }

    Board board = new Board();

    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? "); 
    board.writer = Prompt.inputString("작성자? "); 
    board.password = Prompt.inputString("암호? "); 

    board.no = boardCount == 0 ? 1:  boards[boardCount - 1].no + 1;
    board.viewCount = 0;
    board.createdDated = System.currentTimeMillis();

    // 새로 만든 인스턴스 주소를 레퍼런스 배열에 저장한다.

    boards[boardCount] = board;

    boardCount++;
  }

  static void processDelete() {
    System.out.println("[게시글 삭제]");

    int boardNo = Prompt.inputInt("삭제할 번호? ");

    Board board = null;
    for (int i=0; i< boardCount; i++) {
      if (boards[i].no == boardNo) {
        board = boards[i];
        break;
      }
    }
    // 사용자가 입력한 번호에 해당하는 게시글을 못찾았다면
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }

    // 삭제할 게시글으 다음 항목을 앞으로 당긴다.
    for (int i = boardNo + 1; i < boardCount; i++ ) {
      boards[i-1] = boards[i]; 
    }
    boards[--boardCount] = null;
    System.out.println("삭제했습니다.");
  }

  public static void processUpdate() {
    System.out.println("[게시글 변경]");

    int boardNo = Prompt.inputInt("변경할 게시글 번호? ");

    Board board = null;
    for (int i=0; i< boardCount; i++) {
      if (boards[i].no == boardNo) {
        board = boards[i];
        break;
      }
    }
    // 사용자가 입력한 번호에 해당하는 게시글을 못찾았다면
    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      return;
    }
    // 제목?(원래 제목) xx
    // 내용?(원래 내용) xx

    // 변경하시겠습니가?(y/n)
    // if y -> 변경했습니다.
    // if n -> 변경 취소했습니다.

  }
}



