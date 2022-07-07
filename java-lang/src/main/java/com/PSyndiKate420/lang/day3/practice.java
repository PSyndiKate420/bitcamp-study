package com.PSyndiKate420.lang.day3;

// Scan을 사용하기 위한 import
import java.util.Scanner;


public class practice {
    public static void main(String[] args) {
        // Scanner설정. 변수 이름은 scanner
        Scanner scanner = new Scanner(System.in);

        // ID : admin, PW : 1234 를 입력하면 '관리자님 환영합니다.'라고 출력하며 게시판 활성화
        String ID, AdminID = "admin";
        String PW, AdminPW = "1234";
        int Page = 0;

        // 첫 화면 출력. 다시는 볼 일이 없으니 Switch에 포함 X
        System.out.printf("----------------\n");
        System.out.printf("학점입력 시스템\n");
        System.out.printf("----------------\n");
        // 곧바로 Page를 1로 넘김 
        Page++;

        switch(Page) {
            // Page가 1일 때 무한 반복되는 case
            case 1:
            // 아이디, 비밀번호 입력 오류 카운트를 위한 변수
            /* 1Page에서만 적용되는 변수 */ int WrongCount = 0;
            while(Page == 1) {
                // 오류 카운트가 5보다 작으면
                if(WrongCount < 5) {
                     // ID 입력
                System.out.printf("아이디를 입력하세요 : ");
                ID = scanner.nextLine();
                // 입력한 ID와 관리자 ID를 비교
                // ID = AdminID일시 PW 입력으로 넘어감
                if(ID.equals(AdminID)) {
                    // PW입력
                    System.out.printf("비밀번호를 입력하세요 : ");
                    PW = scanner.nextLine();
                    // 입력한 PW와 관리자 PW를 비교
                    // PW = AdminPW일시 Page를 2로 넘김
                    if(PW.equals(AdminPW)) {
                        System.out.printf("관리자님 환영합니다.\n");
                        Page = 2;
                        break;
                    }
                    // 입력한 PW와 관리자 PW가 다르면 처음으로
                    else if(!PW.equals(AdminPW)) {
                        System.out.printf("비밀번호가 틀렸습니다.\n");
                        // 오류 카운트 +1
                        WrongCount++;
                    }
                }
                // 입력한 ID와 관리자 ID가 다르면 처음으로
                else if(!ID.equals(AdminID)) {
                    System.out.printf("아이디가 틀렸습니다.\n");
                    // 오류 카운트 +1
                    WrongCount++;
                }
            }
            // 오류 카운트가 5 이상이면
            else if(WrongCount >= 5){
                System.out.printf("입력 오류가 5번 누적됐습니다.\n다음에 다시 이용해주세요.\n");
                break;
            }
        }
            case 2:
            while(Page == 2) {
                System.out.printf("----------------\n");
                System.out.printf("성적 입력란입니다\n");
                break;
            }

            default :
            break;
        }

        // scanner 종료
        scanner.close();
    }

}
