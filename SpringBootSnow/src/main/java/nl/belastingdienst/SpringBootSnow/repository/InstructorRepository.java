package nl.belastingdienst.SpringBootSnow.repository;

import nl.belastingdienst.SpringBootSnow.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
