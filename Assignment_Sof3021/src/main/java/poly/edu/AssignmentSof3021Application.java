package poly.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@ComponentScan("filter")
//@EntityScan("entity")
public class AssignmentSof3021Application {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentSof3021Application.class, args);
	}

}
