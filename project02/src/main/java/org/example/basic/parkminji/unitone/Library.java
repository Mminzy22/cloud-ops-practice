package org.example.basic.parkminji.unitone;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();


    // 도서관 책 목록에 새 책을 추가
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " 제목의 새로운 책을 추가합니다.");
    }

    // 도서관 회원 목록에 새 회원을 추가
    public void addMember(Member member) {
        members.add(member);
        System.out.println(member.getName() + "님을 회원으로 추가합니다.");
    }

    // 제목으로 책을 찾아서 반환
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println(title +" 제목의 책을 찾을 수 없습니다.");
        return null;
    }

    // 도서관에 있는 모든 책의 정보를 출력
    public void listAllBooks() {
        System.out.println("도서관에 있는 전체 책 정보:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // 빌릴 수 있는(대여 중이 아닌) 책만 출력
    public void listAvailableBooks() {
        System.out.println("대여 가능 책 목록:");
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }
}
