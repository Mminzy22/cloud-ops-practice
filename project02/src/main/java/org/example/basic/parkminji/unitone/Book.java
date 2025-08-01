package org.example.basic.parkminji.unitone;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    // 생성자
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    // 대여 처리
    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " 제목의 책을 대여했습니다.");
        } else {
            System.out.println(title + " 제목의 책은 이미 대여중입니다.");
        }
    }

    // 반납 처리
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " 제목의 책을 반납합니다.");
        } else {
            System.out.println(title + " 제목의 책을 대여하지 않았습니다.");
        }
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getTitle() {
        return title;
    }

    // 책 정보 문자열 반환
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Borrowed: " + isBorrowed;
    }
}
