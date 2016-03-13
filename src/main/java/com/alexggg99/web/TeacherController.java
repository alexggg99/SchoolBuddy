package com.alexggg99.web;

import com.alexggg99.domain.School;
import com.alexggg99.domain.SchoolRepository;
import com.alexggg99.domain.Teacher;
import com.alexggg99.domain.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepo;

    @RequestMapping(method = RequestMethod.GET)
    public List<Teacher> getTeachers() throws InterruptedException {
        Thread.sleep(1000);
        List<Teacher> teachers = (List<Teacher>) teacherRepo.findAll();
        return teachers;
    }

    @RequestMapping(value = "/{teacherId}", method = RequestMethod.GET)
    public Teacher getTeacher(@PathVariable long teacherId){
        Teacher teacher = teacherRepo.findOne(teacherId);
        return teacher;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Teacher createTeacher(@RequestBody Teacher teacher){
        teacherRepo.save(teacher);
        return teacher;
    }

    @RequestMapping(value = "/{teacherId}",method = RequestMethod.PUT)
    public Teacher updateTeacher(@PathVariable long teacherId ,@RequestBody Teacher teacher){
        teacher.setId(teacherId);
        teacherRepo.save(teacher);
        return teacher;
    }

    @RequestMapping(value = "/{teacherId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteTeacher(@PathVariable long teacherId){
        teacherRepo.delete(teacherId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
