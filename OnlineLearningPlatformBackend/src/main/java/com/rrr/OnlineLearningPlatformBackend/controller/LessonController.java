package com.rrr.OnlineLearningPlatformBackend.controller;

import com.rrr.OnlineLearningPlatformBackend.entity.Lesson;
import com.rrr.OnlineLearningPlatformBackend.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
        Lesson createdLesson = lessonService.createLesson(lesson);
        return new ResponseEntity<>(createdLesson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long id) {
        Optional<Lesson> lesson = lessonService.findById(id);
        return lesson.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Lesson>> getAllLessons() {
        List<Lesson> lessons = lessonService.findAll();
        return ResponseEntity.ok(lessons);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Long id, @RequestBody Lesson updatedLesson) {
        Optional<Lesson> existingLesson = lessonService.findById(id);
        if (existingLesson.isPresent()) {
            Lesson lesson = existingLesson.get();
            // Update lesson properties
            lesson.setTitle(updatedLesson.getTitle());
            lesson.setDescription(updatedLesson.getDescription());
            lesson.setVideoUrl(updatedLesson.getVideoUrl());
            // ... update other properties as needed

            Lesson savedLesson = lessonService.updateLesson(lesson);
            return ResponseEntity.ok(savedLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        Optional<Lesson> lesson = lessonService.findById(id);
        if (lesson.isPresent()) {
            lessonService.deleteLesson(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}