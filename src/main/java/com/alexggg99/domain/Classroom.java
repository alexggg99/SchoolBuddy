package com.alexggg99.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexggg99 on 25.01.16.
 */

@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "classroom" ,fetch = FetchType.LAZY)
    private List<Activity> activityList = new ArrayList<>();

    public Classroom() {
    }

    public Classroom(String name, Teacher teacher, School school) {
        this.name = name;
        this.teacher = teacher;
        this.school = school;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}
