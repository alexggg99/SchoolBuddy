package com.alexggg99.web;

import com.alexggg99.domain.Activity;
import com.alexggg99.domain.ActivityRepository;
import com.alexggg99.domain.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@RestController
@RequestMapping("/activity")
public class ActivitiesController {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ClassroomRepository classroomRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Activity> getActivities() throws InterruptedException {
        Thread.sleep(1000);
        List<Activity> activities = (List<Activity>) activityRepository.findAll();
        return activities;
    }

    @RequestMapping(value = "/{activityId}", method = RequestMethod.GET)
    public Activity getActivity(@PathVariable long activityId){
        Activity activity = activityRepository.findOne(activityId);
        return activity;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Activity createActivity(@RequestBody Activity activity){
        activityRepository.save(activity);
        return activity;
    }

    @RequestMapping(value = "/{activityId}",method = RequestMethod.PUT)
    public Activity updateActivity(@PathVariable long activityId ,@RequestBody Activity activity){
        activity.setId(activityId);
        activityRepository.save(activity);
        return activity;
    }

    @RequestMapping(value = "/{activityId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteActivity(@PathVariable long activityId){
        activityRepository.delete(activityId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{classroomId}/detail/{monthIncome}",method = RequestMethod.GET)
    public List<Activity> getClassroomDetailes(@PathVariable long classroomId,
                                               @PathVariable int monthIncome){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, (monthIncome-1));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date date1 = calendar.getTime();

        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        Date date2 = calendar.getTime();

        List<Activity> activities = classroomRepository.findByClassroomId(classroomId, date1, date2);
        return activities;
    }

    @RequestMapping(value = "/{classroomId}/detail")
    public List<Activity> getActivitiesByClassroom(@PathVariable int classroomId){
        List<Activity> activities = activityRepository.findByClassroom(classroomId);
        return activities;
    }

}
