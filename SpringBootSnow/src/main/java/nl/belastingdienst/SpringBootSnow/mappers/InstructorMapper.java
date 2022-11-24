package nl.belastingdienst.SpringBootSnow.mappers;

import nl.belastingdienst.SpringBootSnow.domain.Instructor;
import nl.belastingdienst.SpringBootSnow.dtos.InstructorDto;

public class InstructorMapper {

    public static InstructorDto mapToDto(Instructor instructor){
        InstructorDto dto = new InstructorDto();

        dto.setId(instructor.getId());
        dto.setFirstName(instructor.getFirstName());
        dto.setLastName(instructor.getLastName());
        dto.setDob(instructor.getDob());
        dto.setLicenceType(instructor.getLicenceType());
        return dto;
    }

    public static Instructor mapToEntity(InstructorDto instructorDto) {
       return mapToEntity(new Instructor(),instructorDto);
    }

    public static Instructor mapToEntity(Instructor instructor, InstructorDto instructorDto) {
        instructor.setFirstName(instructorDto.getFirstName());
        instructor.setLastName(instructorDto.getLastName());
        instructor.setDob(instructorDto.getDob());
        instructor.setLicenceType(instructorDto.getLicenceType());
        instructor.setLesson(instructorDto.getLesson());
        return instructor;
    }
}
