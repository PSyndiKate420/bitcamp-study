/*
 * 사용자로부터 키보드 입력을 받는 도구를 구비하고 있다.
 */
package com.bitcamp.board;

import java.util.Scanner;


// Scanner 함수를 처리하는 클래스
public class Prompt {

  // Scanner 함수 출력
  // 다른 Class에서도 사용하기 때문에 static부여
  static Scanner keyboardInput = new Scanner(System.in);

  // int 값을 다루는 클래스
  static int inputInt() {
    // string값을 전부 받아온 후
    String str = keyboardInput.nextLine();
    // string값을 int값으로 바꿔 string값은 떨어져 나가도록 설정
    return Integer.parseInt(str);
  }

  // int값을 받기 전에 문장을 출력하는 클래스
  // 구조는 위의 inputInt와 똑같으나 ()안에 변수 String title이 추가됨
  static int inputInt(String title) {
    // String tile이 먼저 출력되도록 sysout
    System.out.print(title);
    // string값을 전부 받아온 후
    String str = keyboardInput.nextLine();
    // string값을 int값으로 바꿔 stirng값은 떨어져 나가도록 설정
    return Integer.parseInt(str);
  }

  // string값을 다루는 클래스
  static String inputString() {
    // string값을 전부 받아옴
    return keyboardInput.nextLine();
  }

  // string값을 받기 전에 문장을 출력하는 클래스
  // 구조는 위의 inputString과 똑같으나 ()안에 변수 String title이 추가됨
  static String inputString(String title) {
    // String tile이 먼저 출력되도록 sysout
    System.out.print(title);
    // string값을 전부 받아옴
    return keyboardInput.nextLine();
  }

  // Scanner를 닫아주는 Class
  static void close() {
    keyboardInput.close();
  }
}
