package com.eomcs.oop.ex02.domainTest;

public class Score2 {

  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public Score2(String n, int k, int e, int m) {
    this.name = n;
    this.kor = k;
    this.eng = e;
    this.math = m;
    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }
}
