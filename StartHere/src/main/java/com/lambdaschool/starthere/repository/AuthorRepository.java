package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Authors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public interface AuthorRepository extends PagingAndSortingRepository<Authors, Long>
{
    ArrayList<Authors> findAuthorsByLastnameAndFirstname(String lastname, String firstname);

}
