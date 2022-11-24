package nl.belastingdienst.SpringBootSnow.repository;

import nl.belastingdienst.SpringBootSnow.domain.Discipline;
import nl.belastingdienst.SpringBootSnow.domain.Gear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GearRepository extends JpaRepository<Gear, Long> {
    Gear findFirstByDisciplineAndAndInUseFalse(Discipline discipline);
}
