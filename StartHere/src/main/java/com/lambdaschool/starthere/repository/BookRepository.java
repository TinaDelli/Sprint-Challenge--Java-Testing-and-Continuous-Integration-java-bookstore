package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>
{
    List<Book> findByBooktitleContainingIgnoreCase(String title, Pageable pageable);
}
