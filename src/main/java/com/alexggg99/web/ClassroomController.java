package com.alexggg99.web;

import com.alexggg99.domain.Classroom;
import com.alexggg99.domain.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomRepository classroomRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Classroom> getClassrooms(){
        List<Classroom> classrooms = (List<Classroom>) classroomRepository.findAll();
        return classrooms;
    }

    @RequestMapping(value = "/{classroomId}", method = RequestMethod.GET)
    public Classroom getClassroom(@PathVariable long classroomId){
        Classroom classroom = classroomRepository.findOne(classroomId);
        return classroom;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Classroom createSchool(@RequestBody Classroom classroom){
        classroomRepository.save(classroom);
        return classroom;
    }

    @RequestMapping(value = "/{classroomId}",method = RequestMethod.PUT)
    public Classroom updateClassroom(@PathVariable long classroomId ,@RequestBody Classroom classroom){
        classroom.setId(classroomId);
        classroomRepository.save(classroom);
        return classroom;
    }

    @RequestMapping(value = "/{classroomId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteClassroom(@PathVariable long classroomId){
        classroomRepository.delete(classroomId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
