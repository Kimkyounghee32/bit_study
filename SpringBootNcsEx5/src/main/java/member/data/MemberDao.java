package member.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDao {
	
	@Autowired
	MemberDaoInter dao;
	
	public void insertMember(MemberDto dto) {
		
		dao.save(dto); //id유무에 따라 자동으로 insert 또는 update
	}
	
	
	public List<MemberDto> getAllDatas(){
		
		return (List<MemberDto>) dao.findAll();
	}

	 public MemberDto getData(Long num) 
	 {
		 MemberDto dto=dao.getById(num);
		 return dto;
	 }
	
	//추가도 세이브 수정도 세이브
	
	//DB에 데이타 수정
	public void updateMember(MemberDto dto) {
		dao.save(dto);// num 이 dto 에 포함이므로 수정

	}
	
	//삭제
	public void deleteMember(Long num) {
		dao.deleteById(num);
	}
		
}