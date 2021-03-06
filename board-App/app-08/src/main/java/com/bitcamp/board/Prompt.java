/*
 * 사용자로부터 키보드 입력을 받는 도구를 구비하고 있다.
 */
package com.bitcamp.board;

import java.util.Scanner;

public class Prompt {

    static Scanner keyboardInput = new Scanner(System.in);

    static int inputInt() {
        String str = keyboardInput.nextLine();
        return Integer.parseInt(str);
    }

    static int inputInt(String title) {
        System.out.print(title);
        String str = keyboardInput.nextLine();
        return Integer.parseInt(str);
    }

    static String inputString() {
        return keyboardInput.nextLine();
    }

    static String inputString(String title) {
        System.out.print(title);
        return keyboardInput.nextLine();
    }

    static void close() {
        keyboardInput.close();
    }
}
