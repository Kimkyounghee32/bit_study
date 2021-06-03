package mycar.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyCarDao {

	@Autowired
	MyCarDaoInter dao;
	
	//db에 데이터 추가
	public void insertCar(MyCarDto dto) {
		
		dao.save(dto); //id유무에 따라 자동으로 insert 또는 update
	}
	
	public List<MyCarDto> getAllDatas()
	{
		return dao.findAll(); //반환타입이 list<MyCarDto>
	}
	
	public MyCarDto getData(Long num)
	{
		MyCarDto dto=dao.getById(num);  //겟바이 아이디는 파라미터 받는게 롱 타입으로 받게 되어있음
		return dto;
	}
	
	//추가도 세이브 수정도 세이브
	
	//DB에 데이타 수정
	public void updateCar(MyCarDto dto) {
		dao.save(dto);// num 이 dto 에 포함이므로 수정

	}
	
	//삭제
	public void deleteCar(Long num) {
		dao.deleteById(num);
	}
		
}
