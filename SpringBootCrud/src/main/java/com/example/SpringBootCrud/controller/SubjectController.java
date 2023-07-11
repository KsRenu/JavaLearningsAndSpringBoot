package com.example.SpringBootCrud.controller;

import com.example.SpringBootCrud.bean.Subject;
import com.example.SpringBootCrud.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    private SubjectService subjectService;
    @RequestMapping("/subjects")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/subjects")
    public void addSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/subjects/{id}")
    public void updateSubject(@PathVariable String id,  @RequestBody Subject subject){
        subjectService.updateSubject(id,subject);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/subjects/{id}")
    public void deleteSubject(@PathVariable String id){
        subjectService.deleteSubject(id);
    }

}
