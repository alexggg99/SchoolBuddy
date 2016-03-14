package com.alexggg99.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Alex on 13.03.2016.
 */
public interface UserClassroomRepository extends CrudRepository<UserClassroom, Long> {

    @Query("select a from UserClassroom a join fetch a.classroom where a.user.id = ?1")
    List<UserClassroom> findByUserId(Long userId);

}
