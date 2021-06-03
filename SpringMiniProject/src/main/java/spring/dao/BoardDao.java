package spring.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import spring.dto.BoardDto;

@Repository
public class BoardDao extends SqlSessionDaoSupport {
	public int getTotalCount()
	{
		return getSqlSession().selectOne("totalCountOfBoard");
	}
	
	public int getMaxNum()
	{
		return getSqlSession().selectOne("maxNumOfBoard");
	}
	
	public void updateRestep(int reg,int restep)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("reg", reg);
		map.put("restep", restep);
		getSqlSession().update("updateRestepOfBoard",map);
	}
	
	public void insertBoard(BoardDto dto)
	{
		//원글인지 답글인지에 따라 값이 다르게 dto에 넣어서 전달
		int num=dto.getNum();
		int reg=dto.getReg();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0) //원글인경우(reg는 원글인경우만 바뀜 답글에는 그냥한번 더 넣어준거)
		{
			reg=this.getMaxNum()+1;
			restep=0;
			relevel=0;
		}else {	//답글인경우
			this.updateRestep(reg, restep);
			restep+=1;
			relevel+=1;
		}
		//변경된 3가지 값을 dto에 넣어준다
		dto.setReg(reg);
		dto.setRestep(restep);
		dto.setRelevel(relevel);
		
		getSqlSession().insert("insertOfBoard", dto);
	}
	
	//페이징에서 필요한 부분 list로 보내기
	public List<BoardDto> getList(int start, int perpage)
	{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("perpage", perpage);
		return getSqlSession().selectList("selectPagingOfBoard",map);
	}
	
	
	//[과제]
	//sql에서 선언한 where절에 오는 컬럼에 값을 넣어줘야함
	//getDate와 searchName의 경우에는 데이터를 반환받아야함
	public void updateReadCount(int num)
	{
		getSqlSession().update("updateReadCountOfBoard", num);
	}
	
	public BoardDto getData(int num)
	{
		return getSqlSession().selectOne("selectOneOfBoard",num);
	}
	
	public String searchName(String id)
	{
		return getSqlSession().selectOne("searchNameOfMember", id);
	}
	
	public void updateBoard(BoardDto dto)
	{
		getSqlSession().update("updateOfBoard", dto);
	}
	
	public void deleteBoard(int num)
	{
		getSqlSession().delete("deleteOfBoard", num);
	}
	
	public List<BoardDto> getAllDatas()
	{
		return getSqlSession().selectList("selectAllOfBoard");
	}
	
	public List<BoardDto> getPhotoDatas()
	{
		return getSqlSession().selectList("selectPhotoOfBoard");
	}


	
}
