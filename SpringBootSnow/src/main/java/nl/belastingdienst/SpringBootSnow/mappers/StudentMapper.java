package nl.belastingdienst.SpringBootSnow.mappers;

import nl.belastingdienst.SpringBootSnow.domain.Student;
import nl.belastingdienst.SpringBootSnow.dtos.StudentDto;

public class StudentMapper {

    public static StudentDto mapToDto(Student student){
        StudentDto dto = new StudentDto();

        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setDob(student.getDob());
        dto.setDiscipline(student.getDiscipline());
        dto.setHasOwnGear(student.isHasOwnGear());
        dto.setWeeksOfExperience(student.getWeeksOfExperience());
        return dto;
    }

    public static Student mapToEntity(StudentDto studentDto) {
        return mapToEntity(new Student(), studentDto);
    }

    public static Student mapToEntity(Student student, StudentDto studentDto) {
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(student.getLastName());
        student.setDob(student.getDob());
        student.setGear(student.getGear());
        student.setWeeksOfExperience(student.getWeeksOfExperience());
        student.setGear(student.getGear());
        student.setLesson(student.getLesson());
        return student;
    }
}
