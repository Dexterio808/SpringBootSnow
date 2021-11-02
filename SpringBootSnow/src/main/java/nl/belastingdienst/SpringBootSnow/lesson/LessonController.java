package nl.belastingdienst.SpringBootSnow.lesson;

import nl.belastingdienst.SpringBootSnow.bluePrints.ControllerBP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/lesson")
public class LessonController implements ControllerBP<Lesson> {

    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Override
    public List<Lesson> findAll() {
        return lessonService.findAll();
    }

    @Override
    public Optional<Lesson> findById(Long id) {
        return lessonService.findById(id);
    }

    @Override
    public void save(Lesson lesson) {
        lessonService.save(lesson);
    }

    @Override
    public void update(Long id, Lesson lesson) {
        lessonService.update(id, lesson);
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
