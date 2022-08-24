// iterator 디자인 패턴 : 데이터 목록에서 값을 꺼내는 것을 별도의 객체로 분리하는 설계 방식 
package com.eomcs.design_pattern.iterator.after2;

import java.util.HashSet;

// Iterator 디자인 패턴
// => 데이터 목록을 관리하는 방식에 상관없이 일관된 방식으로 데이터를 꺼낼 수 있게 해주는 설계 기법
// => 즉 데이터 목록을 관리하는 객체를 직접 사용하여 값을 꺼내는 것이 아니라,
//    값을 꺼내는 주는 별도의 객체의 도움을 받아 값을 꺼낸다.
// => 값을 꺼내주는 객체를 "Iterator"라 부른다.
//    값을 꺼내주는 객체의 사용법을 통일하기 위하여 인터페이스로 사용 규칙을 정의한다.
// => 각각의 데이터 목록 관리 객체는 Iterator 규칙에 따라 값을 꺼내는 객체를 리턴한다.
public class Test01 {

  public static void main(String[] args) {
    ArrayList<String> list1 = new ArrayList<>();
    list1.add("aaa");
    list1.add("bbb");
    list1.add("ccc");
    list1.add("ddd");

    LinkedList<String> list2 = new LinkedList<>();
    list2.add("aaa2");
    list2.add("bbb2");
    list2.add("ccc2");
    list2.add("ddd2");

    Stack<String> list3 = new Stack<>();
    list3.push("aaa3");
    list3.push("bbb3");
    list3.push("ccc3");
    list3.push("ddd3");

    Queue<String> list4 = new Queue<>();
    list4.offer("aaa4");
    list4.offer("bbb4");
    list4.offer("ccc4");
    list4.offer("ddd4");

    HashSet<String> list5 = new HashSet<String>();
    list5.add("aaa5");
    list5.add("bbb5");
    list5.add("ccc5");
    list5.add("ddd5");


    /* 목록에서 값 꺼내기
     * 1) ArrayList에서 값 꺼내기
     * */
    Iterator<String> iterator1 = list1.iterator();
    while(iterator1.hasNext()) {
      System.out.println(iterator1.next());
    }
    System.out.println("-----------------------");

    // 2) LinkedList에서 값 꺼내기
    Iterator<String> iterator2 = list2.iterator();
    while(iterator2.hasNext()) {
      System.out.println(iterator2.next());
    }
    System.out.println("-----------------------");

    // 3) Stack에서 값 꺼내는 함수는 pop
    Iterator<String> iterator3 = list3.iterator();
    while(iterator3.hasNext()) {
      System.out.println(iterator3.next());
    }
    System.out.println("-----------------------");

    // 4) Queue에서 값 꺼내는 함수는 poll
    Iterator<String> iterator4 = list4.iterator();
    while(iterator4.hasNext()) {
      System.out.println(iterator4.next());
    }
    System.out.println("-----------------------");

    // 5) HashSet에서 값 꺼내기
    /* => java.util.hashSet의 iterator()가 리턴하는 객체는
     *    우리가 만든 Iterator가 아니라
     *    java.util.Iterator 구현체를 리턴한다.
     *    비록 우리가 만든 Iterator가 아닐지라도 사용법(메소드명)은 같다.
     *  */
    java.util.Iterator<String> iterator5 = list5.iterator();
    while(iterator5.hasNext()) {
      System.out.println(iterator5.next());
    }
    System.out.println("-----------------------");

    /*
     * Iterator 설계 패턴의 특징
     * - 자료 구조에 상관없이 꺼내는 방식이 같다.
     * - 프로그래밍의 일관성을 제공한다.
     * 
     * 문제점
     * - ArrayListIterator는 오직 ArrayList 클래스에서만 데이터를 꺼낸다.
     * - 즉 ArrayList 클래스하고만 작업한다.
     * - 그렇지만 패키지 멤버여서 전체 패키지에 공개되어 있다.
     * 
     * 해결책
     * - 각 Iterator 클래스를 그 Iterator를 생성하는 클래스 안으로 넣어서 쓸데없는 노출을 막는다.
     * */

  }
}






