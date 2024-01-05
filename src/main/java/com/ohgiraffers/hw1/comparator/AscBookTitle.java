package com.ohgiraffers.hw1.comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Comparator;

public class AscBookTitle implements Comparator<BookDTO> {

    public int compare(BookDTO o1, BookDTO o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
