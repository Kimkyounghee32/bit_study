package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.MemberDto;

@Repository //xml �ڵ����(dao���� @Repository)
public class MemberDao extends SqlSessionDaoSupport{
	//id�� �����ϸ� 1, �������� ������ 0��ȯ
	public int getIdCount(String id)
	{
		//�Ķ���ͷ� ���̵� ������, ��� sql���� id=#{id}�� ����
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

	//���̵� ���� ������ �װ���� ��Ƽ���� ��ȯ
	//���̵�� ����� ��� ������ 1 ��ȯ, Ʋ���� 0 ��ȯ�Ǵ� �޼���
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
