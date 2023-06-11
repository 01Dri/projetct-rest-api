package me.dri.restproject.mapper.custom;

import me.dri.restproject.data.vo.v1.BooksVO;
import me.dri.restproject.model.Books;

public class BooksMapper {

    public BooksVO conventyEntityBooksToVO(Books books) {
        BooksVO vo = new BooksVO();
        vo.setKey(books.getId());
        vo.setName(books.getName());
        vo.setGender(books.getGender());
        vo.setRelease_date(books.getRelease_date());
        vo.setNote(books.getNote());
        return vo;
    }

    public Books conventyEntityVOToBooks(BooksVO books) {
        Books book = new Books();
        book.setId(books.getKey());
        book.setName(books.getName());
        book.setGender(books.getGender());
        book.setRelease_date(books.getRelease_date());
        book.setNote(books.getNote());
        return book;
    }
}
