package com.alexggg99.web;

import com.alexggg99.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alex on 13.03.2016.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserClassroomRepository userClassroomRepo;

    @RequestMapping(method = RequestMethod.GET)
    public User getCurrentUser(){
        return currentUser();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getClassrooms")
    public List<UserClassroom> getCurrentUserClassrooms(){
        User user = currentUser();
        List<UserClassroom> result = userClassroomRepo.findByUserId(user.getId());
        return result;
    }

    private User currentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findUserByUsername(auth.getName());
        return user;
    }

}
