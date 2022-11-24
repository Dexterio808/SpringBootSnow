package nl.belastingdienst.SpringBootSnow.repository;

import nl.belastingdienst.SpringBootSnow.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
