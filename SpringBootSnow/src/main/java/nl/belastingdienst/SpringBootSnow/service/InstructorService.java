package nl.belastingdienst.SpringBootSnow.service;

import nl.belastingdienst.SpringBootSnow.domain.Lesson;
import nl.belastingdienst.SpringBootSnow.domain.Instructor;
import nl.belastingdienst.SpringBootSnow.dtos.InstructorDto;
import nl.belastingdienst.SpringBootSnow.mappers.GearMapper;
import nl.belastingdienst.SpringBootSnow.mappers.InstructorMapper;
import nl.belastingdienst.SpringBootSnow.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class InstructorService implements Service<Instructor, InstructorDto> {

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
    public Instructor findById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @Override
    public void save(InstructorDto instructorDto) {
        instructorRepository.save(InstructorMapper.mapToEntity(instructorDto));
    }

    @Override
    public void update(InstructorDto instructorDto) {
        instructorRepository.save(InstructorMapper.mapToEntity(findById(instructorDto.getId()), instructorDto));
    }

    @Override
    public void delete(Long id) {
        if (instructorRepository.existsById(id)) {
            instructorRepository.delete(instructorRepository.getById(id));
        }
    }

    public void addToLesson(Long instructorId, Lesson lesson) {
        if (instructorRepository.existsById(instructorId)) {
            Instructor i = instructorRepository.findById(instructorId).get();
            i.setLesson(lesson);
            instructorRepository.save(i);
        }
    }

}
