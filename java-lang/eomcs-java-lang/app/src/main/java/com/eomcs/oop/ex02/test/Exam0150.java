package com.eomcs.oop.ex02.test;

public class Exam0150 {

  /* 0) 낱개 변수 사용
     1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
     2) 리팩토링: 메소드 추출(extract method), static nested class
     3) 리팩토링: 메소드 추출(extract method) = 한 개의 메소드는 한 개의 기능을 수행해야 한다.
     4) GRASP(General Responsibility Assignment Software Program) 패턴
         => Information Expert: 데이터가 다를 떄는 그 정보를 갖고 있는 객체에게 묻는다.
        리팩토링: 매서드 이동(Move Method)
         => 메서드를 관련된 클래스로 이동시킨다. => 코드의 이해가 쉽다.
     5) 인스턴스 메서드: 인스턴스 주소를 받는 더 쉬운 문법 (this)
   */
  public static void main(String[] args) {

    Score s1 = new Score();
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    s1.compute();
    printScore(s1);

    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;
    s2.compute();
    printScore(s2);

    Score s3 = new Score();
    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;
    s3.compute();
    printScore(s3);
  }

  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    void compute() {
      this.sum = this.kor + this.eng + this.math;
      this.aver = (float) this.sum / 3;
    }
  }
}