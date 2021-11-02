package nl.belastingdienst.SpringBootSnow.Instructor;

import nl.belastingdienst.SpringBootSnow.bluePrints.ControllerBP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/instructor")
public class InstructorController implements ControllerBP<Instructor> {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @Override
    public List<Instructor> findAll() {
        return instructorService.findAll();
    }

    @Override
    public Optional<Instructor> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Instructor instructor) {
        instructorService.save(instructor);
    }

    @Override
    public void update(Long id, Instructor instructor) {

    }

    @Override
    public void delete(Long id) {

    }
}
