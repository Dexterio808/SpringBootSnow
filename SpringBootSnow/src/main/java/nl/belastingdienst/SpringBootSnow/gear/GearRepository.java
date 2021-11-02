package nl.belastingdienst.SpringBootSnow.gear;

import nl.belastingdienst.SpringBootSnow.enums.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GearRepository extends JpaRepository<Gear, Long> {
    Gear findFirstByDisciplineAndAndInUseFalse(Discipline discipline);
}
