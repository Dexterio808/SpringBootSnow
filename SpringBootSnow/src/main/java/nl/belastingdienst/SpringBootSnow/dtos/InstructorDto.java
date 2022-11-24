package nl.belastingdienst.SpringBootSnow.dtos;

import lombok.Data;
import nl.belastingdienst.SpringBootSnow.domain.Lesson;
import nl.belastingdienst.SpringBootSnow.domain.LicenceType;

import java.time.LocalDate;

@Data
public class InstructorDto {

    private long id;
    private LicenceType licenceType;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private Lesson lesson;
}
