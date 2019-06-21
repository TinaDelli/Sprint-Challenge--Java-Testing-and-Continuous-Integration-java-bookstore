package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Authors;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface AuthorRepository extends CrudRepository<Authors, Long>
{
    ArrayList<Authors> findAuthorsByLastnameAndFirstname(String lastname, String firstname);

}
