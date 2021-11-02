package nl.belastingdienst.SpringBootSnow.person.student;

import nl.belastingdienst.SpringBootSnow.bluePrints.ControllerBP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController implements ControllerBP<Student> {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<Student> findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @PostMapping(path = "/save")
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Student student){
        studentService.update(id, student);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }



}
