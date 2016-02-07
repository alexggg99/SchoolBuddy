package com.alexggg99.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by alexggg99 on 25.01.16.
 */

@Entity
@Table(name = "activity")
public class Activity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @Temporal(TemporalType.DATE)
    private Date date;

    public Activity() {
    }

    public Activity(String name, Classroom classroom, Date date) {
        this.name = name;
        this.classroom = classroom;
        this.date = date;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
