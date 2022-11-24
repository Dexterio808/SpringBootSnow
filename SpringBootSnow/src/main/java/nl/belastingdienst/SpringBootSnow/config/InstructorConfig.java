package nl.belastingdienst.SpringBootSnow.config;

import nl.belastingdienst.SpringBootSnow.domain.Instructor;
import nl.belastingdienst.SpringBootSnow.domain.LicenceType;

import nl.belastingdienst.SpringBootSnow.repository.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class InstructorConfig {
    @Bean
    CommandLineRunner configInstructors(InstructorRepository repository) {
        return args -> {
            Instructor tom = new Instructor(
                    "Tom",
                    "De Boer",
                    LocalDate.of(1991, Month.MARCH, 11),
                    LicenceType.SKI_BASIC
            );

            Instructor lisa = new Instructor(
                    "Lisa",
                    "Roma",
                    LocalDate.of(1885, Month.JANUARY, 9),
                    LicenceType.SNOWBOARD_BASIC
            );

            repository.saveAll(
                    List.of(tom, lisa));

        };
    }
}
