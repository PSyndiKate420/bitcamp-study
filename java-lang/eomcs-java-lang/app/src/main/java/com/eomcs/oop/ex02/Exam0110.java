package com.eomcs.oop.ex02;

// 0) 낱개 변수 사용
// 1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
// 2) 리팩토링: 메소드 추출(extract method), static nested class
// 3) 리팩토링: 메소드 추출(extract method) = 한 개의 메소드는 한 개의 기능을 수행해야 한다.
// 4) GRASP(General Responsibility Assignment Software Program)
public class Exam0110 {

  // 여러 메소드에서 공유하려면 클래스 멤버로 만들어야 한다.
  // - 특히 static 멤버끼리 공유하려면 같은 static 멤버로 만들어야 한다.
  static class Score {
    String name; // 변수 또는 필드
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {
    // ## 사용자 정의 데이터 타입 만들기
    // - 학생의 성적 데이터를 담을 메모리(변수)를 설계한다.
    //
    // 사용자 정의 데이터 타입을 사용하는 방법
    // - new 명령을 사용하여 설계도에 기술된 대로 메모리를 준비한다.
    // - 메모리는 Heap 영역에 생성된다.
    // - 메모리 주소를 레퍼런스(주소 변수)에 저장한다.

    Score s1 = new Score();
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    compute(s1);
    printScore(s1);

    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor = 100;
    s2.eng = 90;
    s2.math = 85;
    compute(s2);
    printScore(s2);

    Score s3 = new Score();
    s3.name = "유관순";
    s3.kor = 100;
    s3.eng = 90;
    s3.math = 85;
    compute(s3);
    printScore(s3);

  }

  static void printScore(Score s) {
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math,
        s.sum, s.aver);
  }

  static void compute(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = (float)s.sum / 3;
  }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.


