package org.example.basic.parkminji.unitfifteen;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {
        List<String> nameList = createNameList();
        printNames(nameList);
    }

    private static List<String> createNameList() {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Alice"); // 중복 허용 확인용
        return names;
    }

    private static void printNames(List<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
