package com.alexggg99.domain;

import javax.persistence.*;

/**
 * Created by alexggg99 on 25.01.16.
 */

@Entity
@Table(name = "school")
public class School {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String address;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Teacher director;

    public School() {
    }

    public School(String name, String address, Teacher director) {
        this.name = name;
        this.address = address;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Teacher getDirector() {
        return director;
    }

    public void setDirector(Teacher director) {
        this.director = director;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
