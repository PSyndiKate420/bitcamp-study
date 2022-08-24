package com.eomcs.oop.ex02;

// 0) 낱개 변수 사용
// 1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
// 2) 리팩토링: 메소드 추출(extract method), static nested class
// 3) 리팩토링: 메소드 추출(extract method) = 한 개의 메소드는 한 개의 기능을 수행해야 한다.
// 4) GRASP(General Responsibility Assignment Software Program) 패턴
//    => Information Expert: 데이터가 다를 떄는 그 정보를 갖고 있는 객체에게 묻는다.
//   리팩토링: 매서드 이동(Move Method)
//    => 메서드를 관련된 클래스로 이동시킨다. => 코드의 이해가 쉽다.
public class Exam0140 {

  // 여러 메소드에서 공유하려면 클래스 멤버로 만들어야 한다.
  // - 특히 static 멤버끼리 공유하려면 같은 static 멤버로 만들어야 한다.
  static class Score {
    String name; // 변수 또는 필드
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    // Score()와 관련있는 메소드이기 때문에 이 안에 둔다.
    static void compute(Score s) {
      s.sum = s.kor + s.eng + s.math;
      s.aver = (float)s.sum / 3;
    }
  }

  public static void main(String[] args) {

    Score s1 = new Score();
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    Score.compute(s1);
    printScore(s1);

    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor = 100;
    s2.eng = 90;
    s2.math = 85;
    Score.compute(s2);
    printScore(s2);

    Score s3 = new Score();
    s3.name = "유관순";
    s3.kor = 100;
    s3.eng = 90;
    s3.math = 85;
    Score.compute(s3);
    printScore(s3);

  }

  static void printScore(Score s) {
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math,
        s.sum, s.aver);
  }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.


