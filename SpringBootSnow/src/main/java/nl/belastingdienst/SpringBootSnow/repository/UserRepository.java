package nl.belastingdienst.SpringBootSnow.repository;

import nl.belastingdienst.SpringBootSnow.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
