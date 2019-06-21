package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Book", description = "The Book Entity")
@Entity
@Table(name = "book")
public class Book extends Auditable
{
    @ApiModelProperty(name = "bookid", value = "Primary key for the book", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @ApiModelProperty(name = "booktitle", value = "Book Title", required = true, example = "To Kill A Mockingbird")
    private String booktitle;

    @ApiModelProperty(name = "ISBN", value = "The ISBN number of the book", required = false, example = "123456789")
    private String ISBN;

    @ApiModelProperty(name = "copy", value = "The year the book was published (copyright date)", required = false, example = "1967")
    private int copy;

    @ManyToMany
    @JoinTable(name = "wrote", joinColumns = {@JoinColumn(name = "bookid")},
               inverseJoinColumns = {@JoinColumn(name = "authorid")})
    @JsonIgnoreProperties("books")
    private List<Authors> authors = new ArrayList<>();

    public Book()
    {
    }

    public Book(String booktitle)
    {
        this.booktitle = booktitle;
    }

    public Book(String booktitle, String ISBN, int copy)
    {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;
    }

    public Book(String booktitle, String ISBN, int copy, List<Authors> authors)
    {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.copy = copy;
        this.authors = authors;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBookid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getBooktitle()
    {
        return booktitle;
    }

    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public int getCopy()
    {
        return copy;
    }

    public void setCopy(int copy)
    {
        this.copy = copy;
    }

    public List<Authors> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Authors> authors)
    {
        this.authors = authors;
    }
}
