package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Authors;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorService
{
    List<Authors> findAll(Pageable pageable);

//    Authors findAuthorById(long id);
//
//    List<Authors> findByName(String name);
//
//    void delete(long id);
//
//    Authors save(Authors author);

}
