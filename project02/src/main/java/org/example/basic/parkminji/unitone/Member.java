package org.example.basic.parkminji.unitone;

import java.util.ArrayList;

public class Member {
    private String name;
    private String memberId;
    private ArrayList<Book> borrowedBooks;

    // 생성자
    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // 책 대여
    public void borrow(Book book) {
        if (!book.isBorrowed()) {
            book.borrowBook();
            borrowedBooks.add(book);
        } else {
            System.out.println( book.getTitle() + " 제목의 책이 이미 대여됐습니다.");
        }
    }

    // 책 반납
    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            book.returnBook();
            borrowedBooks.remove(book);
        } else {
            System.out.println(book.getTitle() + " 제목의 책은 대여하지 않았습니다.");
        }
    }

    // 대여 중인 책 목록 출력
    public void listBorrowedBooks() {
        System.out.println(name + "님의 책 대여 목록:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("대여한 책이 없습니다.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println(book);
            }
        }
    }
}
