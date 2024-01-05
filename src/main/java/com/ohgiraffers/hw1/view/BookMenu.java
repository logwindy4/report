package com.ohgiraffers.hw1.view;

import com.ohgiraffers.hw1.controller.BookManager;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.List;
import java.util.Scanner;

public class BookMenu {

    private Scanner sc = new Scanner(System.in);

    private BookManager bm;

    public BookMenu(){
        bm = new BookManager();

    }
    int choice;
    public void mainMenu(){


        do{

            System.out.println("1. 새 도서 추가 ");
            System.out.println("2. 도서 정보 정렬 후 출력 ");
            System.out.println("3. 도서 삭제 ");
            System.out.println("4. 도서 검색출력 ");
            System.out.println("5. 전체 출력 ");
            System.out.println("6. 끝내기 ");
            System.out.print("메뉴를 선택하세요 : ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1 :
                    System.out.println("새 도서를 추가를 선택하셨습니다.");
                    bm.addBook(inputBook());
                    break;
                case 2 :
                    System.out.println("도서 정보 정렬 후 출력을 선택하셨습니다.");
                    selectSortedBook();
                    break;
                case 3 :
                    System.out.println("도서 삭제를 선택하셨습니다 ");
                    bm.deleteBook(inputBookNo());
                    break;
                case 4 :
                    System.out.println("도서 검색을 선택하셨습니다");
                    bm.searchBook(inputBookTitle());
                    break;
                case 5 :
                    System.out.println("전체 출력을 선택하셨습니다.");
                    bm.displayAll();
                    break;
                case 6 :
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다 다시 선택해주세요.");
                    break;
            }



        }while(choice != 6);






    }

    public BookDTO inputBook(){
        System.out.print("추가하실 책의 번호를 입력해주세요 : ");
        int bNo = sc.nextInt();
        System.out.print("추가 하실 도서 장르 ( 1 : 인문 / 2 : 자연과학 / 3 : 의료 / 4: 기타) 를 선택하세요. : ");
        int category = sc.nextInt();
        System.out.print("추가하실 책의 제목을 입력해주세요 : ");
        String title = sc.next();
        System.out.print("추가하실 책의 저자명을 입력해주세요 : ");
        String author = sc.next();

        BookDTO bookDTO = new BookDTO();

        bookDTO.setbNo(bNo);
        bookDTO.setCategory(category);
        bookDTO.setTitle(title);
        bookDTO.setAuthor(author);

        System.out.println("추가하신 도서는" + bookDTO + "입니다.");


        return bookDTO;
    }

    public int inputBookNo(){
        System.out.print("삭제할 도서 번호를 입력하세요:");
        int index = sc.nextInt();
        sc.nextLine();



        return index;
    }

    public String inputBookTitle(){
        System.out.print("검색할 도서 제목을 입력해주세요. : ");
        String title = sc.nextLine();

        return title;
    }

    public List<BookDTO> selectSortedBook(){

        System.out.println("1. 도서번호로 오름차순 정렬");
        System.out.println("2. 도서번호로 내림차순 정렬");
        System.out.println("3. 책 제목으로 오름차순 정렬");
        System.out.println("4. 책 제목으로 내림차순 정렬");

        System.out.println("도서 정렬 방식을 선택해주세요.");
        int no = sc.nextInt();

        List<BookDTO> bookList = bm.sortedBookList(no);
        bm.printBookList(bookList);
        return bookList;

    }

}
