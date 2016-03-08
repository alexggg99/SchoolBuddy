package com.alexggg99.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Alex on 27.11.2015.
 */
public interface ActivityRepository extends CrudRepository<Activity, Long> {
    @Query("select a from Activity a where a.classroom.id = ?1")
    List<Activity> findByClassroom(long classroomId);
}
