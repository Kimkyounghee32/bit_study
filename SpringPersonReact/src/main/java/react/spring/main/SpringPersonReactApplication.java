package react.spring.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import person.data.DatabaseConfig;

@Import(DatabaseConfig.class)
@SpringBootApplication
@ComponentScan({"person.data","react.spring.main"})
public class SpringPersonReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPersonReactApplication.class, args);
	}

}
