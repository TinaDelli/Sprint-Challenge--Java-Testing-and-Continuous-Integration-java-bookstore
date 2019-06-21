package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "Author", description = "The Author Entity")
@Entity
@Table(name = "author")
public class Authors extends Auditable
{
    @ApiModelProperty(name = "authorid", value = "Primary key for Author", required = true, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    @ApiModelProperty(name = "lastname", value = "Author's Last Name", required = true, example = "Rand")
    private String lastname;

    @ApiModelProperty(name = "firstname", value = "Author's First Name", required = true, example = "Ayn")
    private String firstname;

    @ManyToMany(mappedBy = "authorid")
    @JsonIgnoreProperties("authors")
    private List<Book> books = new ArrayList<>();

    public Authors()
    {
    }

    public Authors(String lastname, String firstname)
    {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public Authors(String lastname, String firstname, List<Book> books)
    {
        this.lastname = lastname;
        this.firstname = firstname;
        this.books = books;
    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }
}
