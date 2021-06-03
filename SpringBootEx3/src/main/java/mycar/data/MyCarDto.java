package mycar.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity

//자동으로 mycar 라는 테이블이 생성된다
//만약 기존의 mycar가 있다면 변경된 부분만 업데이트가 된다
@Table(name="mycar") 
@Data //세터게터 자동으로 해주는 lombok도 어노테이션
public class MyCarDto {
	
	@Id //각 엔터티를 구별할 수 있도록 식별 아이디를 갖도록 설계
	@GeneratedValue(strategy = GenerationType.AUTO)//db에 맞게 숫자 자동발생
	private Long num;
	
	@Column(name="carname")
	private String carname;
	
	@Column(name="carprice")
	private int carprice;
	
	@Column(name="carcolor")
	private String carcolor;
	
	@Column(name="carguip")
	private String carguip;
	
	@CreationTimestamp //엔터티가 생성되는 시점의 시간이 자동등록
	@Column(updatable=false) //save로 수정시 이 컬럼은 제외된다
	private Timestamp writeday;
	
	@UpdateTimestamp  //수정시에 생성되는 시간
	private Timestamp updateday;

	
	
}
