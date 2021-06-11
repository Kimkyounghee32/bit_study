package person.data;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("person") //나중에 sql에서 사용할 alias를 person으로 준다.
public class PersonDto {
	private int num;
	private String name;
	private String sajin;
	private String buseo;
	private String hp;
	private String ipsaday;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="Asia/Seoul")
	private Timestamp writeday;

}
