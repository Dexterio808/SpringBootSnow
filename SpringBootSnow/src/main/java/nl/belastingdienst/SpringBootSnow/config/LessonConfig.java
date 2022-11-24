package nl.belastingdienst.SpringBootSnow.config;

import nl.belastingdienst.SpringBootSnow.domain.Lesson;
import nl.belastingdienst.SpringBootSnow.domain.Discipline;
import nl.belastingdienst.SpringBootSnow.repository.LessonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class LessonConfig {

    @Bean
    CommandLineRunner configLessons(LessonRepository lessonRepository) {
        return args -> {
            Lesson lesson = new Lesson(
                    Discipline.SNOWBOARD,
                    LocalDate.of(2021, Month.OCTOBER, 31),
                    LocalDate.of(2021, Month.NOVEMBER, 5)
            );
            lessonRepository.saveAll(List.of(lesson));
        };
    }
}
