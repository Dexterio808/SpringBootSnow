package nl.belastingdienst.SpringBootSnow.boundary;

import nl.belastingdienst.SpringBootSnow.domain.Instructor;
import nl.belastingdienst.SpringBootSnow.dtos.GearDto;
import nl.belastingdienst.SpringBootSnow.dtos.InstructorDto;
import nl.belastingdienst.SpringBootSnow.mappers.InstructorMapper;
import nl.belastingdienst.SpringBootSnow.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/instructor")
public class InstructorResource implements Resource<Instructor, InstructorDto> {

    private final InstructorService instructorService;

    @Autowired
    public InstructorResource(InstructorService instructorService) {
        this.instructorService = instructorService;
    }


    @Override
    public List<InstructorDto> findAll() {
        List<InstructorDto> result = new ArrayList<>();
        instructorService.findAll().forEach(e -> result.add(InstructorMapper.mapToDto(e)));
        return result;
    }

    @Override
    public InstructorDto findById(Long id) {
        return InstructorMapper.mapToDto(instructorService.findById(id));
    }

    @Override
    public void save(InstructorDto instructorDto) {
        instructorService.save(instructorDto);
    }

    @Override
    public void update(InstructorDto instructorDto) {
        instructorService.update(instructorDto);
    }

    @Override
    public void delete(Long id) {
        instructorService.delete(id);
    }
}
