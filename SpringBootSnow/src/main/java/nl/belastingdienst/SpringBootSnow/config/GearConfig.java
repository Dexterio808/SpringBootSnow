package nl.belastingdienst.SpringBootSnow.config;

import nl.belastingdienst.SpringBootSnow.domain.Gear;
import nl.belastingdienst.SpringBootSnow.domain.Discipline;
import nl.belastingdienst.SpringBootSnow.repository.GearRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GearConfig {
    @Bean
    CommandLineRunner configGear(GearRepository gearRepository) {
        return args -> {
            Gear gear1 = new Gear(Discipline.SNOWBOARD);
            Gear gear2 = new Gear(Discipline.SNOWBOARD);
            Gear gear3 = new Gear(Discipline.SKI);
            Gear gear4 = new Gear(Discipline.SKI);

            gearRepository.saveAll(List.of(
                    gear1,
                    gear2,
                    gear3,
                    gear4));
        };
    }
}
