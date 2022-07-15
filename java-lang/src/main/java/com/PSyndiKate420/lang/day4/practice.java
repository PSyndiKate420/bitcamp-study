package com.PSyndiKate420.lang.day4;

import java.util.Scanner; // 입력을 사용하기 위한 import

public class practice {
    public static void main(String[] args) {
        // Scanner설정. 변수 이름은 scanner
        Scanner scanner = new Scanner(System.in);

        // ID : admin, PW : 1234 를 입력하면 '관리자님 환영합니다.'라고 출력하며 게시판 활성화
        String ID, AdminID = "admin";
        String PW, AdminPW = "1234";
        int Page = 0;

        // 첫 화면 출력. 다시는 볼 일이 없으니 while에 포함 X
        System.out.printf("----------------");
        System.out.println();
        System.out.printf("게시판 어플리케이션");
        System.out.println();
        System.out.printf("----------------");
        System.out.println();
        // 곧바로 Page를 1로 넘김 
        Page++;

        switch(Page) {
            // Page 1 일때 실행되는 case
            case 1:
            // 아이디, 비밀번호 입력 오류 카운트를 위한 변수
            /* 1Page에서만 적용되는 변수 */ int WrongCount = 0;

            // while문의 조건을 Page == 1로 설정하여 case 1에 종속되도록 설정
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
        // case 2일 때 실행되는 class
        case 2:

        /* 메뉴 선택에 필요한 변수 모음집 */
        int menuNumber;                         // 메뉴 번호
            
        /* 게시판에 필요한 변수 모음집 */
        final int SIZE = 3;                     // 게시판 배열의 크기. final int를 사용해 여기서만 변경 가능
        int[] no = new int[SIZE];               // 게시판 번호
        String[] titles= new String[SIZE];      // 게시판 제목
        String[] contents = new String[SIZE];   // 게시판 내용
        String[] writers = new String[SIZE];    // 게시판 작성자
        String[] password = new String[SIZE];   // 게시판 암호 (아직은 사용 X)
        int[] viewCount = new int[SIZE];        // 게시판 조회수 (아직은 사용 X)
        long[] createdDate = new long[SIZE];    // 게시판 등록일
        int boardCount = 0;                     // 

        // 등록일 출력을 위한 현재시간 util 및 시간 간소화 출력 text import
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");

        // 두 번째 화면 출력. 다시는 볼일 없으니 while에 포함 X
        System.out.printf("----------------");
        System.out.println();
        System.out.printf("[게시판 어플리케이션]");
        System.out.println();
        System.out.println("환영합니다!");
        System.out.println();
        System.out.printf("----------------");
        System.out.println();
        
        // while문의 조건을 Page == 1로 설정하여 case 2에 종속되도록 설정
        while (Page == 2) {
            System.out.println("메뉴:");
            System.out.println("  1. 게시글 목록");
            System.out.println("  2. 게시글 상세보기");
            System.out.println("  3. 게시글 등록");
            System.out.println();
            System.out.printf("메뉴를 선택하세요[1..3](0.종료) ");

            //메뉴 선택 Scanner
            menuNumber = scanner.nextInt();
            // int값만 가져가기 때문에 String값인 "엔터"를 빼내야 함.
            scanner.nextLine();

                // 사용자가 '0'번을 입력
                if(menuNumber == 0) {
                    System.out.println("안녕히 가세요.");
                    // 곧장 종료
                    break;
                // 사용자가 '1'번을 입력
                } else if (menuNumber == 1) {
                    System.out.println("[게시글 목록]");
                    System.out.println("번호 제목 조회수 작성자 등록일");

                    for(int i = 0; i < boardCount; i++) {
                        // 현재 시각을 등록일로 설정하기 위해 Date 유틸리티를 가져옴
                        java.util.Date date = new java.util.Date(createdDate[i]);
                        String dateStr = df.format(date);
    
                        System.out.printf("%d\t%s\t%d\t%s\t%s\n",
                          no[i], titles[i], viewCount[i], writers[i], dateStr);
                    }
                } else if (menuNumber == 2) {
                    System.out.println("게시판 상세보기");
    
                    System.out.printf("조회할 게시글 번호? ");
                    String input = scanner.nextLine();
                    int boardNo = Integer.parseInt(input);
    
                    int boardIndex = -1;
                    for (int i=0; i< boardCount; i++) {
                        if (no[i] == boardNo) {
                            boardIndex = i;
                            break;
                        }
                    }
    
                    // 사용자가 입력한 번호에 해당하는 게시글을 못찾았다면
                    if (boardIndex == -1) {
                        System.out.println("해당 번호의 게시글이 없습니다!");
                        continue;
                    }
                    System.out.printf("번호 : %d\n", no[boardIndex]);
                    System.out.printf("제목 : %s\n", titles[boardIndex]);
                    System.out.printf("내용 : %s\n", contents[boardIndex]);
                    System.out.printf("조회수 : %d\n", viewCount[boardIndex]);
                    System.out.printf("작성자 : %s\n", writers[boardIndex]);
                    java.util.Date date = new java.util.Date(createdDate[boardIndex]);
                    System.out.printf("등록일 : %tY-%1$tm-%1$td\n", date);
                } else if(menuNumber == 3) {
                    System.out.println("[게시글 등록]");
    
                    // 배열의 크기를 초과하지 않았는지 검사한다.
                    if (boardCount == SIZE) {
                        System.out.println("게시글의 최대 개수를 초과했습니다!");
                        continue;
                    }
    
                    System.out.println("제목? ");
                    titles[boardCount] = scanner.nextLine();
    
                    System.out.println("내용? ");
                    contents[boardCount] = scanner.nextLine();
    
                    System.out.println("제목?");
                    writers[boardCount] = scanner.nextLine();
    
                    System.out.println("암호? ");
                    password[boardCount] = scanner.nextLine();
                    
                    no[boardCount] = boardCount == 0 ? 1:  no[boardCount - 1] + 1;
                    viewCount[boardCount] = 0;
                    createdDate[boardCount] = System.currentTimeMillis();
    
                    boardCount++;
                }   else {
                    System.out.println("메뉴 번호가 옳지 않습니다.");
                    scanner.close();
                }
                System.out.println();
            }

            default :
            break;
        }
        // scanner 종료
        scanner.close();
    }
}
