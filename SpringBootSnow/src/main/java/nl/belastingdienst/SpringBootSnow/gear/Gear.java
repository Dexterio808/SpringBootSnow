package nl.belastingdienst.SpringBootSnow.gear;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.belastingdienst.SpringBootSnow.enums.Discipline;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Gear {
    @Id
    @SequenceGenerator(
            name = "gear_sequence",
            sequenceName = "gear_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gear_sequence"
    )
    private Long id;

    private Discipline discipline;
    private boolean inUse;

    public Gear(Discipline discipline) {
        this.discipline = discipline;
    }
}
