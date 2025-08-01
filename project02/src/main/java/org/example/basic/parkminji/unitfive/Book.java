package org.example.basic.parkminji.unitfive;

public class Book {
    private String title;
    private String author;
    private int price;

    public Book() {
        this.title = "제목 없음";
        this.author = "저자 미상";
        this.price = 0;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0;
    }

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("제목: " + title);
        System.out.println("저자: " + author );
        System.out.println("가격: " + price + "원");
    }
}
