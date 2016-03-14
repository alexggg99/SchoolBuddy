package com.alexggg99.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by alexggg99 on 02.07.15.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/schools")
    public String schools() {
        return "index";
    }

    @RequestMapping("/classrooms")
    public String classrooms() {
        return "index";
    }

    @RequestMapping("/classrooms/{id}")
    public String classroomId() {
        return "index";
    }

    @RequestMapping("/classrooms/{id}/detail/{month}")
    public String classroomDetailes() {
        return "index";
    }

    @RequestMapping("/classrooms/{id}/summary")
    public String classroom_parentClassroom_summary() {
        return "index";
    }

    @RequestMapping("/myClassrooms")
    public String myClassrooms() {
        return "index";
    }

//    @RequestMapping("/classrooms/{id}/detail/{month}")
//    public String classroomDetailes() {
//        return "index";
//    }

    @RequestMapping("/activities")
    public String activities() {
        return "index";
    }

    @RequestMapping("/classrooms/{id}/*")
    public String classroomDetails() {
        return "index";
    }

}
