package org.example.basic.parkminji.uniteleven;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("과일 목록 첫 번째: " + fruits.get(0));

        fruits.remove("Banana");
        fruits.add(1, "Mango");

        System.out.println("수정된 목록: " + fruits);
        System.out.println("수정 후 첫 번째 과일: " + fruits.get(0));

        printAllFruits(fruits); // for 문으로 전체 조회
    }

    private static void printAllFruits(List<String> fruits) {
        System.out.println("전체 과일 목록:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
