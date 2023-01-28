package nl.belastingdienst.SpringBootSnow;

import nl.belastingdienst.SpringBootSnow.domain.AppUser;
import nl.belastingdienst.SpringBootSnow.domain.Role;
import nl.belastingdienst.SpringBootSnow.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringBootSnowApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSnowApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new AppUser(null, "pepijn tournoij", "tourp", "1234", new ArrayList<>()));

			userService.addRoleToUser("tourp", "ROLE_USER");
			userService.addRoleToUser("tourp", "ROLE_ADMIN");
		};
	}
}
