package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Authors;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{
    @Autowired
    BookRepository bookrepos;

    @Override
    public ArrayList<Book> findAll(Pageable pageable)
    {
        ArrayList<Book> list = new ArrayList<>();
        bookrepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book findBookById(long id) throws EntityNotFoundException
    {
        return bookrepos.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public List<Book> findBookByNameLike(String name, Pageable pageable)
    {
        List<Book> list = new ArrayList<>();
        bookrepos.findByBooktitleContainingIgnoreCase(name, pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if(bookrepos.findById(id).isPresent())
        {
            bookrepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Book save(Book book)
    {
        Book newBook = new Book();

        newBook.setBooktitle(book.getBooktitle());

        for(Authors a: book.getAuthors())
        {
            newBook.getAuthors().add(new Authors(a.getLastname(), a.getFirstname()));
        }

        return bookrepos.save(newBook);
    }

    @Override
    public void savetoAuthor(long book, long authorid)
    {
        bookrepos.savetoAuthor(book, authorid);
    }

    @Override
    public Book update(Book book, long id)
    {
        Book currentBook = bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (book.getBooktitle() != null)
        {
            currentBook.setBooktitle(book.getBooktitle());
        }
        return bookrepos.save(currentBook);
    }
}
