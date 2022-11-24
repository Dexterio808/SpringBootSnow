package nl.belastingdienst.SpringBootSnow.repository;

import nl.belastingdienst.SpringBootSnow.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
