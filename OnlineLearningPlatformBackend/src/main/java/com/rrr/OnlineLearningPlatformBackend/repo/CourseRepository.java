package com.rrr.OnlineLearningPlatformBackend.repo;

import com.rrr.OnlineLearningPlatformBackend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructorUsername(String instructorUsername);

    @Query("SELECT c FROM Course c JOIN c.instructor i WHERE i.username = :instructorUsername")
    List<Course> findCoursesByInstructorUsername(@Param("instructorUsername") String instructorUsername);
}