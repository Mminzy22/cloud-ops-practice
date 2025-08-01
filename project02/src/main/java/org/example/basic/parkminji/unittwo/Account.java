package org.example.basic.parkminji.unittwo;


public class Account {
    // private 필드
    private String accountNumber;
    private String ownerName;
    private double balance;

    // 생성자
    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // 입금 메서드
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("입금 금액은 0보다 커야함");
            return;
        }
        balance += amount;
        System.out.println(amount + "원 입금 완료");
    }

    // 출금 메서드
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("출금 금액은 0보다 커야함");
            return;
        }

        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + "원이 출금됨");
        } else {
            System.out.println("잔액 부족으로 출금 불가");
        }
    }

    // 계좌 정보 출력 메서드
    public void printAccountInfo() {
        System.out.println("계좌번호: " + accountNumber);
        System.out.println("예금주명: " + ownerName);
        System.out.println("잔액: " + balance + "원");
    }
}
