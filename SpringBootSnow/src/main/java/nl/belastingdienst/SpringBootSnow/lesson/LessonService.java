package nl.belastingdienst.SpringBootSnow.lesson;

import nl.belastingdienst.SpringBootSnow.bluePrints.ServiceBP;
import nl.belastingdienst.SpringBootSnow.person.instructor.InstructorService;
import nl.belastingdienst.SpringBootSnow.person.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService implements ServiceBP<Lesson> {

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
    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }

    @Override
    public void save(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void update(Long id, Lesson lesson) {
        if (lessonRepository.existsById(id)){
            Lesson l = lessonRepository.findById(id).get();
            l.setDiscipline(lesson.getDiscipline());
            l.setStartDate(lesson.getStartDate());
            l.setEndDate(lesson.getEndDate());
            lessonRepository.save(l);
        }
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
