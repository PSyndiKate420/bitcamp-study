package com.eomcs.oop.ex02.domain;

// 다른 패키지에서도 사용할 수 있도록 공개
public /* 공개*/ class Score {

  // 다른 패키지에서 이 설계도에 따라 만든 변수에 접근할 수 있도록
  // 접근 범위를 넓힌다.


  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  // static method == > instance method
  public void compute() {
    /* 인스턴드 메서드를 호출할 때 넘겨준 인스턴스 주소는
         this 라는 내장 변수(built-in)에 보관된다.
     */
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }
}
