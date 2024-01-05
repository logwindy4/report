package com.ohgiraffers.hw1.comparator;

import com.ohgiraffers.hw1.model.dto.BookDTO;

import java.util.Comparator;

public class AscBookNo implements Comparator<BookDTO> {
    @Override
    public int compare(BookDTO o1, BookDTO o2) {
        // 오름차순
        int result = 0;

        if (o1.getbNo() > o2.getbNo()) {
            return 1;
        } else if (o1.getbNo() < o2.getbNo()) {

            result = -1;
        } else {
            result = 0;
        }

        return result;
    }
}