package nl.belastingdienst.SpringBootSnow.person.student;

import nl.belastingdienst.SpringBootSnow.enums.Discipline;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner configStudents(StudentRepository studentRepository) {
        return args -> {
            Student pepijn = new Student(
                    "Pepijn",
                    "Tournoij",
                    LocalDate.of(1996, Month.MARCH, 28),
                    6,
                    Discipline.SNOWBOARD,
                    true
            );

            Student maarten = new Student(
                    "Maarten",
                    "Thijs",
                    LocalDate.of(1996, Month.APRIL, 6),
                    5,
                    Discipline.SNOWBOARD,
                    false
            );

            studentRepository.saveAll(
                    List.of(pepijn, maarten));

        };
    }
}
