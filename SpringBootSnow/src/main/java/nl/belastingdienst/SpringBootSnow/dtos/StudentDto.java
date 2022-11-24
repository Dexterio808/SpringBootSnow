package nl.belastingdienst.SpringBootSnow.dtos;

import lombok.Data;
import nl.belastingdienst.SpringBootSnow.domain.Discipline;

import java.time.LocalDate;

@Data
public class StudentDto {

    private long id;
    private int weeksOfExperience;
    private Discipline discipline;
    private boolean hasOwnGear;
    private String firstName;
    private String lastName;
    private LocalDate dob;

}
