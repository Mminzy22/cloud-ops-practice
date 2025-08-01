package org.example.basic.parkminji.unitfifteen;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        Set<String> fruitSet = createFruitSet();
        printFruits(fruitSet);
    }

    private static Set<String> createFruitSet() {
        Set<String> fruits = new HashSet<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("apple"); // 중복 허용되지 않음
        return fruits;
    }

    private static void printFruits(Set<String> fruits) {
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
