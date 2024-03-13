package com.rrr.OnlineLearningPlatformBackend.repo;

import com.rrr.OnlineLearningPlatformBackend.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourseId(Long courseId);

    @Query("SELECT l FROM Lesson l JOIN l.course c WHERE c.id = :courseId")
    List<Lesson> findLessonsByCourseId(@Param("courseId") Long courseId);
}