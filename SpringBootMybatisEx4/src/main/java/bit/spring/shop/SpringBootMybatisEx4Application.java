package bit.spring.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//@ComponentScan가 있어야 톰캣인식한다
@ComponentScan({"boot.shop.data","shop.controller"})
public class SpringBootMybatisEx4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisEx4Application.class, args);
	}

}
