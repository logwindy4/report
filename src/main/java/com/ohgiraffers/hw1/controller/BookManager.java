package com.ohgiraffers.hw1.controller;

import com.ohgiraffers.hw1.comparator.AscBookNo;
import com.ohgiraffers.hw1.comparator.AscBookTitle;
import com.ohgiraffers.hw1.comparator.DescBookNo;
import com.ohgiraffers.hw1.comparator.DescBookTitle;
import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager {

    private ArrayList<BookDTO> bookList;

    private Scanner sc = new Scanner(System.in);

    public BookManager() {
        bookList = new ArrayList<>();
    }

    public void addBook(BookDTO book){
        bookList.add(book);
    }

    public void deleteBook(int index){
        bookList.remove(index - 1);
    }

    public void searchBook(String title){
        int count = 0;
        for (int i = 0 ; i < bookList.size(); i ++){
            if (bookList.get(i).getTitle().contains(title)){
                System.out.println("검색한 도서는 " + bookList.get(i) + "입니다.");
                count++;
            }
        }
        if (count == 0){
            System.out.println("조회한 도서가 목록에 없습니다.");}

    }

    public void displayAll(){
        if (bookList.size() == 0) {
            System.out.println("출력 결과가 없습니다.");}

        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(i + " " + bookList.get(i));

        }


    }

    public List<BookDTO> sortedBookList(int type){

        switch (type) {
            case 1:
                bookList.sort(new AscBookNo());
                break;
            case 2:
                bookList.sort(new DescBookNo());
                break;
            case 3:
                bookList.sort(new AscBookTitle());
                break;
            case 4:
                bookList.sort(new DescBookTitle());
                break;

        }
        return bookList;
    }

    public void printBookList(List<BookDTO> bookList){
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }
    }
}
