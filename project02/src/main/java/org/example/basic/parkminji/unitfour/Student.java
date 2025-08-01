package org.example.basic.parkminji.unitfour;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void printInfo() {
        System.out.println("이름: " + name);
        System.out.println("점수: " + score);
        System.out.println("---------------");
    }

    public boolean isHighScore() {
        return score >= 90;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
