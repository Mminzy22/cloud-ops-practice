package org.example.basic.parkminji.unitfour;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // 학생 5명
        students.add(new Student("민지", 95));
        students.add(new Student("만지", 80));
        students.add(new Student("먼지", 90));
        students.add(new Student("문지", 75));
        students.add(new Student("몬지", 85));

        // 모든 학생 정보
        System.out.println("모든 학생 정보:");
        System.out.println("---------------");
        for (Student s : students) {
            s.printInfo();
        }

        // 평균 점수
        double sum = 0;
        for (Student s : students) {
            sum += s.getScore();
        }
        double avg = sum / students.size();
        System.out.println("\n전체 평균 점수: " + avg);

        // 90점 이상 학생만
        System.out.println("\n90점 이상 학생:");
        System.out.println("---------------");
        for (Student s : students) {
            if (s.isHighScore()) {
                s.printInfo();
            }
        }

        // 점수 순으로 정렬
        System.out.println("\n점수 높은 순 정렬:");
        System.out.println("---------------");
        students.sort(Comparator.comparingInt(Student::getScore).reversed());
        for (Student s : students) {
            s.printInfo();
        }

        // 입력으로 학생 추가
        Scanner sc = new Scanner(System.in);
        System.out.print("\n추가할 학생 이름 입력: ");
        String newName = sc.nextLine();
        System.out.print("추가할 학생 점수 입력: ");
        int newScore = sc.nextInt();

        Student newStudent = new Student(newName, newScore);
        students.add(newStudent);

        System.out.println("\n학생 추가 후 전체 목록:");
        System.out.println("---------------");
        for (Student s : students) {
            s.printInfo();
        }
        sc.close();
    }
}
