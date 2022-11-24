package nl.belastingdienst.SpringBootSnow.service;

import nl.belastingdienst.SpringBootSnow.domain.Lesson;
import nl.belastingdienst.SpringBootSnow.domain.Student;
import nl.belastingdienst.SpringBootSnow.dtos.StudentDto;
import nl.belastingdienst.SpringBootSnow.mappers.StudentMapper;
import nl.belastingdienst.SpringBootSnow.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class StudentService implements Service<Student, StudentDto> {

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

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);

    }

    public void save(StudentDto studentDto) {
        studentRepository.save(StudentMapper.mapToEntity(studentDto));
    }

    public void update(StudentDto studentDto) {
       studentRepository.save(StudentMapper.mapToEntity(findById(studentDto.getId()), studentDto));
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
