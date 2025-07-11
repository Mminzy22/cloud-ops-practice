package org.example;

public class Cat extends Animal{

    @Override
    void sound(){
        System.out.println("야옹");
    }

    public static void main(String[] args) {
        Animal myCat = new Cat();
        myCat.sound();
    }
}
