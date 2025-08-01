package org.example.basic.parkminji.unitseven;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("지민", 20, "서울대학교");
        Worker w = new Worker("민수", 30, "카카오");

        s.introduce(); // Person 클래스 메서드
        s.study();     // Student 클래스 메서드

        System.out.println();

        w.introduce(); // Person 클래스 메서드
        w.work();      // Worker 클래스 메서드
    }
}
