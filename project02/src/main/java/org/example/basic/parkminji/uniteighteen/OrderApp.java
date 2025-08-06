package org.example.basic.parkminji.uniteighteen;

import java.util.Scanner;

public class OrderApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static int totalPrice = 0;

    public static void main(String[] args) {
        while (true) {
            CoffeeType type = inputCoffeeType();
            CoffeeSize size = inputCoffeeSize();

            CoffeeOrder order = new CoffeeOrder(type, size);
            System.out.println(order);

            totalPrice += order.getPrice();

            if (!askContinue()) {
                printTotal();
                break;
            }
        }
        scanner.close();
    }

    private static CoffeeType inputCoffeeType() {
        while (true) {
            try {
                System.out.println("\n커피 종류를 선택하세요: AMERICANO, LATTE, CAPPUCCINO");
                return CoffeeType.valueOf(scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 커피 종류입니다. 다시 입력해주세요.");
            }
        }
    }

    private static CoffeeSize inputCoffeeSize() {
        while (true) {
            try {
                System.out.println("사이즈를 선택하세요: SMALL, MEDIUM, LARGE");
                return CoffeeSize.valueOf(scanner.nextLine().trim().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 사이즈입니다. 다시 입력해주세요.");
            }
        }
    }

    private static boolean askContinue() {
        System.out.print("\n계속 주문하시겠습니까? (yes/no): ");
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    private static void printTotal() {
        System.out.printf("%n총 주문 금액: %,d원%n", totalPrice);
    }
}
