package bit.spring.boot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"test.rest","test.rest2"})
public class SpringBootEx2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEx2Application.class, args);
	}

}
