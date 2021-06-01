package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MemberDto;

@Repository //xml 자동등록(dao에는 @Repository)
public class MemberDao extends SqlSessionDaoSupport{
	//id가 존재하면 1, 존재하지 않으면 0반환
	public int getIdCount(String id)
	{
		//파라미터로 아이디를 보내고, 멤버 sql에서 id=#{id}로 받음
		return getSqlSession().selectOne("idCheckOfMember",id);
	}
	
	public void insertMember(MemberDto dto)
	{
		getSqlSession().insert("insertOfMember",dto);
	}
	
	public List<MemberDto> getAllMembers()
	{
		return getSqlSession().selectList("listAllOfMember");
	}

	//아이디에 맵을 보내면 그결과를 인티져로 반환
	//아이디와 비번이 모두 맞으면 1 반환, 틀리면 0 반환되는 메서드
	public int loginCheck(String id, String pass)
	{
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id",id);
		map.put("pass", pass);
		return getSqlSession().selectOne("loginCheckOfMember",map);
	}
	
	public MemberDto getMember(String num) 
	{
		return getSqlSession().selectOne("selectOneOfMember",num);
	}
	
	public int passCheck(String num,String pass)
	{
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("num", num);
		map.put("pass", pass);
		int count=getSqlSession().selectOne("passCheckOfMember",map);
		return count;
	}

	public void updateOfMember(MemberDto dto) 
	{
		getSqlSession().update("updateOfMember", dto);	
	}
	
	public void deleteMember(String num)
	{
		getSqlSession().delete("deleteOfMember",num);
	}
	
}
