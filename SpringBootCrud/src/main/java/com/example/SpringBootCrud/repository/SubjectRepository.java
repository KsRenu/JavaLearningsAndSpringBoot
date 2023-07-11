package com.example.SpringBootCrud.repository;

import com.example.SpringBootCrud.bean.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepository extends CrudRepository<Subject, String> {

}
