package nl.belastingdienst.SpringBootSnow.boundary;

import nl.belastingdienst.SpringBootSnow.domain.Lesson;
import nl.belastingdienst.SpringBootSnow.dtos.LessonDto;
import nl.belastingdienst.SpringBootSnow.mappers.GearMapper;
import nl.belastingdienst.SpringBootSnow.mappers.LessonMapper;
import nl.belastingdienst.SpringBootSnow.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/lesson")
public class LessonResource implements Resource<Lesson, LessonDto> {

    private final LessonService lessonService;

    @Autowired
    public LessonResource(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Override
    public List<LessonDto> findAll() {
        List<LessonDto> result = new ArrayList<>();
        lessonService.findAll().forEach(e -> result.add(LessonMapper.mapToDto(e)));
        return result;
    }

    @Override
    public LessonDto findById(Long id) {
        return LessonMapper.mapToDto(lessonService.findById(id));
    }

    @Override
    public void save(LessonDto lessonDto) {
        lessonService.save(lessonDto);
    }

    @Override
    public void update(LessonDto lessonDto) {
        lessonService.update(lessonDto);
    }

    @Override
    public void delete(Long id) {
        lessonService.delete(id);
    }

    @PostMapping(path = "/addStudents/{lessonId}")
    public void addStudents(@RequestParam Long[] studentId,
                            @PathVariable Long lessonId){
        lessonService.addStudents(lessonId, studentId);
    }

    @PostMapping(path = "/addInstructor/{lessonId}/{instructorId}")
    public void addInstructor(@PathVariable Long instructorId,
                              @PathVariable Long lessonId) {
        lessonService.addInstructor(lessonId, instructorId);
    }

}
