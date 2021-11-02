package nl.belastingdienst.SpringBootSnow.person.student;

import nl.belastingdienst.SpringBootSnow.bluePrints.ServiceBP;
import nl.belastingdienst.SpringBootSnow.gear.GearService;
import nl.belastingdienst.SpringBootSnow.lesson.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements ServiceBP<Student> {

    private final StudentRepository studentRepository;
    private final GearService gearService;

    @Autowired
    public StudentService(StudentRepository studentRepository, GearService gearService) {
        this.studentRepository = studentRepository;
        this.gearService = gearService;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
        if (!student.isHasOwnGear()) {
            rentalProcedure(student.getId());
        }

    }

    public void update(Long id, Student student) {
        if (studentExists(id)) {
            Student s = studentRepository.findById(id).get();
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setDob(student.getDob());
            studentRepository.save(s);
        }
    }

    public void delete(Long id) {
        if (studentExists(id)) {
            studentRepository.delete(studentRepository.getById(id));
        }
    }

    public void addToLesson(Long studentId, Lesson lesson) {
        if (studentExists(studentId)) {
            Student s = studentRepository.findById(studentId).get();
            s.setLesson(lesson);
            studentRepository.save(s);
        }
    }


    public void rentalProcedure(Long id) {
        if (studentExists(id)) {
            Student s = studentRepository.findById(id).get();
            s.setGear(gearService.allocateGear(s.getDiscipline()));
            studentRepository.save(s);
        }
    }

    public void rentalTurnIn(Long id){
        if (studentExists(id)) {
            Student s = studentRepository.findById(id).get();
            if (gearService.deallocateGear(s.getGear().getId())){
                s.setGear(null);
            }
            studentRepository.save(s);
        }
    }

    private boolean studentExists(Long studentId) {
        return studentRepository.existsById(studentId);
    }
}
