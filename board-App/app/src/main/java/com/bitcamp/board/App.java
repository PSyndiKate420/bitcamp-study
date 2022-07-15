/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.bitcamp.board;

public class App {

  public static void main(String[] args) {

    Fundamental.welcome();
    // Fundamental.Login();
    loop: while(true) {
      displayMenu();
      int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0.종료) ");
      Fundamental.displayLine();
      switch(menuNo) {
        case 0: break loop;
        case 1: BoardHandler.processList(); break;
        case 2: BoardHandler.processDetail(); break;
        case 3: BoardHandler.processInput(); break;
        case 4: BoardHandler.processDelete(); break;
        case 5: BoardHandler.processUpdate(); break;
        default: System.out.println("메뉴 번호가 옳지 않습니다."); break;
      }
    }
  } 
  static void displayMenu() {
    System.out.println("메뉴:");
    System.out.println("  1. 게시글 목록");
    System.out.println("  2. 게시글 상세보기");
    System.out.println("  3. 게시글 등록");
    System.out.println("  4. 게시글 삭제");
    System.out.println("  5. 게시글 변경");
    System.out.println();
  }
}
