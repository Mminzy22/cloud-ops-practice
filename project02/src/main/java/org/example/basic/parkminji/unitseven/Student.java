package org.example.basic.parkminji.unitseven;

public class Student extends Person {
    String school;

    public Student(String name, int age, String school) {
        super(name, age); // 부모 생성자 호출
        this.school = school;
    }

    public void study() {
        System.out.println(name + "은(는) " + school + "에서 공부하고 있습니다.");
    }
}
