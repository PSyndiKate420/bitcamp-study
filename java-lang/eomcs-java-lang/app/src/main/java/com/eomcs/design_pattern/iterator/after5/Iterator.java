package com.eomcs.design_pattern.iterator.after5;

// 데이터 조회를 수행하는 객체 사용법 정의
public interface Iterator<E> {

  // 목록에 조회할 데이터가 있는지 검사할 때 호출
  boolean hasNext();

  E next();

}