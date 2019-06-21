package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>
{
    List<Book> findByBooktitleContainingIgnoreCase(String title, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO wrote(bookid, authorid) values (:bookid, :authorid)", nativeQuery = true)
    void savetoAuthor(long bookid, long authorid);
}
