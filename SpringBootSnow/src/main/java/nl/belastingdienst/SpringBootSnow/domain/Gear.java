package nl.belastingdienst.SpringBootSnow.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Gear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Discipline discipline;
    private boolean inUse;

    public Gear(Discipline discipline) {
        this.discipline = discipline;
    }
}
