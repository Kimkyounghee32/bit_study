package bit.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"*.controller","mycar.data"})
@EntityScan("mycar.data")
@EnableJpaRepositories("mycar.data")
public class SpringBootEx3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEx3Application.class, args);
	}

}
