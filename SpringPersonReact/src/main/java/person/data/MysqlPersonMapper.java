package person.data;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MysqlPersonMapper {
	
	public List<PersonDto> getAllDatas();
	public void insertPerson(PersonDto dto);
	public PersonDto getData(String num);
	public void deleteData(String num);
}
