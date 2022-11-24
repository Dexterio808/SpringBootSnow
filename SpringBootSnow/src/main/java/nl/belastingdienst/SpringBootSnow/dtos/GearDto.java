package nl.belastingdienst.SpringBootSnow.dtos;

import lombok.Data;
import nl.belastingdienst.SpringBootSnow.domain.Discipline;

@Data
public class GearDto {

    private long id;
    private Discipline discipline;
    private boolean inUse;
}
