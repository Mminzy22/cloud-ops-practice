package org.example;

import org.example.top.Flyable;

import java.util.Scanner;

public class Bird implements Flyable, Walkable{
    @Override
    public void fly() {
        System.out.println("새가 날아갑니다.");
    }

    public static void main(String[] args) {
        Bird myBird = new Bird();
        myBird.fly();
        myBird.walk();
    }

    @Override
    public void walk() {
        System.out.println("새가 걷습니다.");
    }
}
