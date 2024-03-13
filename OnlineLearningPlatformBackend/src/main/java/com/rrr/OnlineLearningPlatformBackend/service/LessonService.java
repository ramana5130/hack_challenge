package com.rrr.OnlineLearningPlatformBackend.service;

import com.rrr.OnlineLearningPlatformBackend.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rrr.OnlineLearningPlatformBackend.repo.LessonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson createLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Lesson updateLesson(Lesson updatedLesson) {
        return lessonRepository.save(updatedLesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}