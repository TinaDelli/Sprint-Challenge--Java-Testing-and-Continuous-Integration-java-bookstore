package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Authors;
import com.lambdaschool.starthere.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private AuthorRepository authrepos;

    @Override
    public List<Authors> findAll(Pageable pageable)
    {
        List<Authors> list = new ArrayList<>();
        authrepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

//    @Override
//    public Authors findAuthorById(long id)
//    {
//        return null;
//    }
//
//    @Override
//    public List<Authors> findByName(String name)
//    {
//        return null;
//    }
//
//    @Override
//    public void delete(long id)
//    {
//
//    }
//
//    @Override
//    public Authors save(Authors author)
//    {
//        return null;
//    }
}
