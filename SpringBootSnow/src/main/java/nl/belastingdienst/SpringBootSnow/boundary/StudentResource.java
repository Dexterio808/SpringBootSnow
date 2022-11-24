package nl.belastingdienst.SpringBootSnow.boundary;

import nl.belastingdienst.SpringBootSnow.domain.Student;
import nl.belastingdienst.SpringBootSnow.dtos.StudentDto;
import nl.belastingdienst.SpringBootSnow.mappers.StudentMapper;
import nl.belastingdienst.SpringBootSnow.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentResource implements Resource<Student, StudentDto> {

    private final StudentService studentService;

    @Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentDto> findAll(){
        List<StudentDto> result = new ArrayList<>();
        studentService.findAll().forEach(e -> result.add(StudentMapper.mapToDto(e)));
        return result;
    }

    @GetMapping(path = "/{id}")
    public StudentDto findById(@PathVariable Long id){
        return StudentMapper.mapToDto(studentService.findById(id));
    }

    @PostMapping(path = "/save")
    public void save(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@RequestBody StudentDto studentDto){
        studentService.update(studentDto);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }



}
