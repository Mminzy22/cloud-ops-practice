package org.example.basic.parkminji.uniteight.interfaceuse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Payment method;

        System.out.println("결제 수단을 선택하세요 (1: 신용카드, 2: 카카오페이): ");
        int choice = sc.nextInt();

        System.out.println("결제할 금액을 입력하세요: ");
        int amount = sc.nextInt();

        if (choice == 1) {
            method = new CreditCardPayment();
        } else if (choice == 2) {
            method = new KakaoPay();
        } else {
            System.out.println("잘못된 선택입니다.");
            sc.close();
            return;
        }

        method.pay(amount);
        sc.close();
    }
}
