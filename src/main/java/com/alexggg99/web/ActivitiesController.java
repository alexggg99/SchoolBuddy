package com.alexggg99.web;

import com.alexggg99.domain.Activity;
import com.alexggg99.domain.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@RestController
@RequestMapping("/activity")
public class ActivitiesController {

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Activity> getActivities(){
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

}
