package nl.belastingdienst.SpringBootSnow.Instructor;

import nl.belastingdienst.SpringBootSnow.bluePrints.ServiceBP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService implements ServiceBP<Instructor> {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Optional<Instructor> findById(Long id) {
        return instructorRepository.findById(id);
    }

    @Override
    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public void update(Long id, Instructor instructor) {
        if (instructorRepository.existsById(id)){
            Instructor i = instructorRepository.findById(id).get();
            i.setFirstName(instructor.getFirstName());
            i.setLastName(instructor.getLastName());
            i.setDob(instructor.getDob());
            instructorRepository.save(i);
        }
    }

    @Override
    public void delete(Long id) {
        if (instructorRepository.existsById(id)){
            instructorRepository.delete(instructorRepository.getById(id));
        }
    }
}
