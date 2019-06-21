package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Book;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface BookService
{
    ArrayList<Book> findAll(Pageable pageable);

    Book findBookById(long id);

    List<Book> findBookByNameLike(String name, Pageable pageable);

//    ArrayList<CountBooksFromAuthors> getCountBooksFromAuthors();

    void delete(long id);

    Book save (Book book);

    void savetoAuthor(long bookid, long authorid);

    Book update(Book book, long id);
}
