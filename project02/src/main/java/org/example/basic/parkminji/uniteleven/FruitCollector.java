package org.example.basic.parkminji.uniteleven;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FruitCollector {

    public static void main(String[] args) {
        List<String> fruits = getUserInputFruits();
        printFruitList(fruits);
    }

    private static List<String> getUserInputFruits() {
        Scanner scanner = new Scanner(System.in);
        List<String> fruits = new ArrayList<>();

        System.out.println("과일 이름 5개를 입력하세요:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + "번째 과일: ");
            String fruit = scanner.nextLine();
            fruits.add(fruit);
        }

        scanner.close();
        return fruits;
    }

    private static void printFruitList(List<String> fruits) {
        System.out.println("입력한 과일 목록: " + fruits);
    }
}
