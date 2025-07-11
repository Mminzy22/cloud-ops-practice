package org.example;


public class IfSwitchExample {
    public static void main(String[] args) {
        System.out.println("if문과 switch문 메소드 예제");
        System.out.println();
        System.out.println(ifTest(10));
        System.out.println(switchTest(3));
    }

    public static String ifTest(int num){
        // if문
        System.out.printf("if문 " + num + "이 0보다 큰가?\n");
        String str;
        if (num > 0) {
            str = "양수입니다.";
        } else if (num == 0) {
            str = "0입니다.";
        } else {
            str = "음수입니다.";
        }
        return str;
    }

    public static String switchTest(int day) {
        String str;
        System.out.printf("switch문 "+day+"이 무슨 요일인지 확인하기\n");
        switch (day) {
            case 1:
                str = "월요일";
                break;
            case 2:
                str = "화요일";
                break;
            case 3:
                str = "수요일";
                break;
            default:
                str = "기타 요일";
                break;
        }
        return str;
    }
}