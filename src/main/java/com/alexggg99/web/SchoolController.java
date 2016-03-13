package com.alexggg99.web;

import com.alexggg99.domain.School;
import com.alexggg99.domain.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<School> getSchools() throws InterruptedException {
        Thread.sleep(1000);
        List<School> schools = (List<School>) schoolRepo.findAll();
        return schools;
    }

    @RequestMapping(value = "/{schoolId}", method = RequestMethod.GET)
    public School getSchool(@PathVariable long schoolId){
        School contact = schoolRepo.findOne(schoolId);
        return contact;
    }

    @RequestMapping(method = RequestMethod.POST)
    public School createSchool(@RequestBody School school){
        schoolRepo.save(school);
        return school;
    }

    @RequestMapping(value = "/{schoolId}",method = RequestMethod.PUT)
    public School updateSchool(@PathVariable long schoolId ,@RequestBody School school){
        school.setId(schoolId);
        schoolRepo.save(school);
        return school;
    }

    @RequestMapping(value = "/{schoolId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSchool(@PathVariable long schoolId){
        schoolRepo.delete(schoolId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
