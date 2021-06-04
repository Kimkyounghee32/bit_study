package member.data;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Table(name="memberNCS")
@Data
public class MemberDto {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //DB에 맞게 숫자 자동발생
	private Long num;
	
	@Column(name="name")
	private String name;
	
	@Column(name="id")
	private String id;
	
	@Column(name="pass")
	private String pass;
	
	@Column(name="job")
	private String job;
	
	@Column(name="addr")
	private String addr;
	
	@Column(name="email")
	private String email;
	
	@Column(name="hp")
	private String hp;
	
	@Column(name="birthday") //save로 수정시 이 컬럼은 제외된다
	private String birthday;

	

}
