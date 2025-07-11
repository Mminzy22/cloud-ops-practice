package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void listTest(){
        List<Integer> intList1 = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            intList1.add(i);
        }
        System.out.println(intList1);
    }

    public void listTextTest(){
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        System.out.println(list);
        System.out.println("첫 번째 요소: " + list.get(0));
        System.out.println("두 번째 요소: " + list.get(1));

        for(int i = 0; i < list.size(); i++){
            System.out.println("리스트 아이템: " + list.get(i));
        }

        for(String item : list){
            System.out.println("향상된 for문 버전) 리스트 아이템: " + item);
        }

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        System.out.println(intList);

        List<Integer> intList1 = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            intList1.add(i);
        }
        System.out.println(intList1);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(3.14);
        doubleList.add(2.71);
        System.out.println(doubleList);

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Cat());
        animalList.add(new Dog());
        for (Animal animal : animalList) {
            animal.sound();
        }
    }
    public static void main(String[] args) {
        listTest();
    }
}
