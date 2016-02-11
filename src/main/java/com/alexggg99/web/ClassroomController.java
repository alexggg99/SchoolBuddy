package com.alexggg99.web;

import com.alexggg99.domain.Activity;
import com.alexggg99.domain.Classroom;
import com.alexggg99.domain.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

    @RequestMapping(value = "/{classroomId}/detail/{monthIncome}",method = RequestMethod.GET)
    public List<Activity> getClassroomDetailes(@PathVariable long classroomId,
                                               @PathVariable int monthIncome){
//        int year = Calendar.getInstance().get(Calendar.YEAR);
//        String month = monthIncome <= 9 ? '0' + String.valueOf(monthIncome) : String.valueOf(monthIncome);
//        Calendar date1 = GregorianCalendar.getInstance();
//        date1.set(Calendar.MONTH, monthIncome);
//        SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/yyyy");
//        String inputString2 = null;
//        try{
//            inputString2 = sdf.format(date1);
//        }catch(Exception ex){
//            System.out.println(ex);
//        }
//        System.out.println(inputString2);
//        List<Activity> activities = null;
//                //classroomRepository.findByClassroomId(classroomId);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, (monthIncome-1));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date date1 = calendar.getTime();

        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        Date date2 = calendar.getTime();
        System.out.println(date2);
        List<Activity> activities = classroomRepository.findByClassroomId(classroomId, date1, date2);
        return null;
    }

}
