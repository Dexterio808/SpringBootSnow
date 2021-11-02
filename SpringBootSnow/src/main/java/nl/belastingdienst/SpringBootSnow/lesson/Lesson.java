package nl.belastingdienst.SpringBootSnow.lesson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import nl.belastingdienst.SpringBootSnow.enums.Discipline;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Lesson {
    @Id
    @SequenceGenerator(
            name = "lesson_sequence",
            sequenceName = "lesson_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "lesson_sequence"
    )
    private Long id;

    private Discipline discipline;
    private LocalDate startDate;
    private LocalDate endDate;

    public Lesson(Discipline discipline, LocalDate startDate, LocalDate endDate) {
        this.discipline = discipline;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
