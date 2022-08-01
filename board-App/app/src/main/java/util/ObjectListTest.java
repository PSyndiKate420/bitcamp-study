package util;

import com.bitcamp.board.domain.Member;

public class ObjectListTest {
  public static void main(String[] args) {
    Object obj = new Object();
    System.out.println(obj.toString());

    Member obj2 = new Member();
    System.out.println(obj2.toString());

    String obj3 = new String();
    System.out.println(obj3.toString());

    //    ObjectList list = new ObjectList();
    //    list.add("홍길동");
    //    list.add("임꺽정");
    //    list.add("유관순");
    //
    //
    //    Object obj = list.get(0);
    //    System.out.println(obj);
    //
    //    obj = list.get(1);


    //    System.out.println(obj.toString());
    //
    //    obj = list.get(2);
    //    System.out.println(obj.toString());
  }

}
