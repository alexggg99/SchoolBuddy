package com.alexggg99.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 27.11.2015.
 */
public interface ClassroomRepository extends CrudRepository<Classroom, Long> {

    @Query("select a from Activity a where a.classroom.id = ?1 and a.date between ?2 and ?3")
    List<Activity> findByClassroomId(Long classroomId, Date date1, Date date2 );

}
