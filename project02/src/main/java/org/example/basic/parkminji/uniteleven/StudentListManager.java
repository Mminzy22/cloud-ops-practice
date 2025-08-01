package org.example.basic.parkminji.uniteleven;

import java.util.ArrayList;
import java.util.List;

public class StudentListManager {

    public static void main(String[] args) {
        List<String> students = new ArrayList<>();

        addStudents(students);
        removeStudent(students, "Charlie");
        printAllStudents(students);
        printStudentAtIndex(students, 1);
    }

    private static void addStudents(List<String> list) {
        list.add("Alice");
        list.add("Bob");
        list.add("Charlie");
        list.add("David");
        list.add("Eve");
    }

    private static void removeStudent(List<String> list, String name) {
        list.remove(name);
    }

    private static void printAllStudents(List<String> list) {
        System.out.println("전체 학생 목록: " + list);
    }

    private static void printStudentAtIndex(List<String> list, int index) {
        if (index >= 0 && index < list.size()) {
            System.out.println(index + "번 인덱스 학생: " + list.get(index));
        } else {
            System.out.println("잘못된 인덱스입니다.");
        }
    }
}
