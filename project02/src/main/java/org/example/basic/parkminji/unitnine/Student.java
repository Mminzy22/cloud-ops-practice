package org.example.basic.parkminji.unitnine;

public class Student {
    private String name;
    private int score;
    private int grade;  // 1~6만 허용

    // 생성자
    public Student(String name, int score, int grade) {
        this.name = name;
        setScore(score);
        setGrade(grade);
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getGrade() {
        return grade;
    }

    // Setter
    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("점수 범위 오류 (0~100)");
        }
    }

    public void setGrade(int grade) {
        if (grade >= 1 && grade <= 6) {
            this.grade = grade;
        } else {
            System.out.println("학년 범위 오류 (1~6)");
        }
    }

    // 점수 등급 반환
    public String getGradeLevel() {
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }

    // 학생 정보 출력
    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("점수: " + score);
        System.out.println("등급: " + getGradeLevel());
        System.out.println("학년: " + grade);
        System.out.println();
    }
}
