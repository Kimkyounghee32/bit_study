package mycar.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/*
 * public interface MyCarDaoInter extends CrudRepository<MyCarDto, Long>{
 * 
 * }
 */

public interface MyCarDaoInter extends JpaRepository<MyCarDto, Long>{
	
	
}