package nl.belastingdienst.SpringBootSnow.dtos;

import lombok.Data;
import nl.belastingdienst.SpringBootSnow.domain.Discipline;

import java.time.LocalDate;

@Data
public class LessonDto {

    private long id;
    private Discipline discipline;
    private LocalDate startDate;
    private LocalDate endDate;
}
