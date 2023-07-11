package com.example.SpringBootCrud.service;

import com.example.SpringBootCrud.bean.Subject;
import com.example.SpringBootCrud.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    public SubjectRepository subjectrepo;

    public List<Subject> getAllSubjects(){
        List<Subject> subjects = new ArrayList<>();
        subjectrepo.findAll().forEach(subjects::add);
        return subjects;
    }

    public void addSubject(Subject subject) {
        subjectrepo.save(subject);
    }


    public void updateSubject(String id, Subject subject) {
        subjectrepo.save(subject);
        //subjectrepo.findById(id);

    }

    public void deleteSubject(String id) {
        subjectrepo.deleteById(id);
    }
}
