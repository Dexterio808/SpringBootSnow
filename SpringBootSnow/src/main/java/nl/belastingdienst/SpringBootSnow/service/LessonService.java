package nl.belastingdienst.SpringBootSnow.service;

import nl.belastingdienst.SpringBootSnow.domain.Lesson;
import nl.belastingdienst.SpringBootSnow.dtos.LessonDto;
import nl.belastingdienst.SpringBootSnow.mappers.LessonMapper;
import nl.belastingdienst.SpringBootSnow.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class LessonService implements Service<Lesson, LessonDto> {

    private final LessonRepository lessonRepository;
    private final StudentService studentService;
    private final InstructorService instructorService;

    @Autowired
    public LessonService(LessonRepository lessonRepository, StudentService studentService, InstructorService instructorService) {
        this.lessonRepository = lessonRepository;
        this.studentService = studentService;
        this.instructorService = instructorService;
    }


    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public Lesson findById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Override
    public void save(LessonDto lessonDto) {
        lessonRepository.save(LessonMapper.mapToEntity(lessonDto));
    }

    @Override
    public void update(LessonDto lessonDto) {
       lessonRepository.save(LessonMapper.mapToEntity(findById(lessonDto.getId()), lessonDto));
    }

    @Override
    public void delete(Long id) {
        if (lessonRepository.existsById(id)){
            lessonRepository.delete(lessonRepository.getById(id));
        }
    }

    public void addStudents(Long lessonId, Long[] studentIds) {
        if (lessonRepository.existsById(lessonId)) {
            for (long studentId : studentIds) {
                    studentService.addToLesson(studentId, lessonRepository.getById(lessonId));
            }
        }
    }

    public void addInstructor(Long lessonId, Long instructorId){
        if (lessonRepository.existsById(lessonId)) {
                instructorService.addToLesson(instructorId, lessonRepository.getById(lessonId));
        }
    }
}
