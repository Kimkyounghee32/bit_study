package bit.spring.ncs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"*.controller", "member.data"})
@EntityScan("member.data")
@EnableJpaRepositories("member.data")
public class SpringBootNcsEx5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNcsEx5Application.class, args);
	}

}
