package org.example.basic.parkminji.unitthree;

public class Customer {

    private String name;
    private String grade;
    private int point;

    // 생성자
    public Customer(String name, String grade) {
        this.name = name;
        this.grade = grade;
        this.point = 0;
    }

    // 할인 계산
    public int calculateDiscountPrice(int price) {
        int discountPrice = price;

        if (grade.equals("GOLD")) {
            discountPrice = (int)(price * 0.90);
        } else if (grade.equals("SILVER")) {
            discountPrice = (int)(price * 0.95);
        } else {
            discountPrice = price;
        }
        return discountPrice;
    }

    // 고객 정보 출력
    public void showCustomerInfo() {
        System.out.println("고객 이름: " + name);
        System.out.println("회원 등급: " + grade);
        System.out.println("적립 포인트: " + point);
    }

    // 포인트 적립
    public void earnPoints(int price) {
        int basePoint = 0;

        if (grade.equals("GOLD")) {
            basePoint = (int)(price * 0.02);
        } else if (grade.equals("SILVER")) {
            basePoint = (int)(price * 0.01);
        } else {
            basePoint = 0;
        }

        point += basePoint;
        System.out.println(name + "님의 추가된 적립 포인트: " + basePoint + "점");
    }
}
