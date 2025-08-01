package org.example.basic.parkminji.unitnine;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // 학생 추가
        students.add(new Student("민지", 92, 3));
        students.add(new Student("만지", 75, 2));
        students.add(new Student("먼지", 58, 1));
        students.add(new Student("몬지", 85, 4));

        // 전체 출력
        for (Student s : students) {
            s.printInfo();
        }

        // 잘못된 점수와 학년 테스트
        System.out.println("\n잘못된 입력 테스트:");
        Student invalidStudent = new Student("오류학생", 150, 10);  // 경고 출력
        invalidStudent.printInfo();
    }
}
