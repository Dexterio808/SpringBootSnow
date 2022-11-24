package nl.belastingdienst.SpringBootSnow.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
