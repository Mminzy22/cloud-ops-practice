package org.example.basic.parkminji.unittwo;

import java.util.Scanner;


public class AccountProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 계좌 정보 입력
        System.out.print("계좌번호 입력: ");
        String accountNumber = sc.nextLine();

        System.out.print("예금주명 입력: ");
        String ownerName = sc.nextLine();

        System.out.print("초기 잔액 입력: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        Account myAccount = new Account(accountNumber, ownerName, balance);

        System.out.println("\n계좌 생성 완료");
        myAccount.printAccountInfo();

        // 간단한 메뉴 제공
        while (true) {
            System.out.println("\n[메뉴]");
            System.out.println("1. 입금");
            System.out.println("2. 출금");
            System.out.println("3. 계좌 정보 보기");
            System.out.println("4. 종료");
            System.out.print("선택 >> ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("입금할 금액: ");
                    double depositAmount = sc.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("출금할 금액: ");
                    double withdrawAmount = sc.nextDouble();
                    myAccount.withdraw(withdrawAmount);
                    break;
                case 3:
                    myAccount.printAccountInfo();
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    sc.close();
                    return;
                default:
                    System.out.println("잘못된 선택으로 다시 선택 필요함");
            }
        }
    }
}
