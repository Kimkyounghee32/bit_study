package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.SmartDto;
import oracle.db.DbConnect;

public class SmartDao {
	DbConnect db=new DbConnect();
	
	//num max=null 일 경우 0값 리턴
	public int getMaxNum()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		String sql="select nvl(max(num),0) from smartbbs"; 
		//NVL 함수는 값이 null인 경우 지정값을 출력한다=멕시멈 num을 출력하는데, 널일때는 0 출력
		
		int n=0;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				n=rs.getInt(1);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return n;
	}
		
	
	//insert(
	public void insertSmart(SmartDto dto)
	{
		
		String sql="insert into smartbbs values (seq_mini.nextval,"
				+ "?,?,?,0,sysdate)";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			
			//실행
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//전체 갯수 구하기
	public int getTotalCount()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		String sql="select count(*) from smartbbs"; 
		
		int n=0;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next())
				n=rs.getInt(1);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return n;
	}
	
	//페이징처리에 필요한 리스트만 보내기
	public List<SmartDto> getList(int start, int end)
	{
		List<SmartDto> list=new Vector<SmartDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		 String sql = "select a.* from (select ROWNUM as RNUM,b.* from "
		            + "(select * from smartbbs order by num desc)b)a "
		            + "where a.RNUM>=? and a.RNUM<=?"; //페이징처리할꺼니까 물음표는 그대로
		 
		 		//epleSmart order by reg desc,restep asc
		 		//리플보드인데 순서를 reg의 내림차순 restep의 오름차순
		 		//제이쿼리 이용할 때도 이 문법 그대로 사용하면됨
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			//실행
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				SmartDto dto=new SmartDto();
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
				list.add(dto);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	//num에 해당하는 readcount 1 증가
	public int updateReadcount(String num) 
	{	
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="update smartbbs set readcount=readcount+1 where num=?";
		int n=0;
		conn=db.getConnection();
		
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		return n;
	}
	
	//num에 해당하는 dto데이터 반환
	public SmartDto getData(String num) 
	{
		SmartDto dto=new SmartDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		String sql="select * from smartbbs where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReadcount(rs.getInt("readcount"));
				dto.setWriteday(rs.getTimestamp("writeday"));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
		
	}
	
	//수정
		public void updateSmart(SmartDto dto) 
		{	
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="update smartbbs set writer=?, subject=?, content=? "
					+ "where num=?";
			
			conn=db.getConnection();
			
			
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, dto.getWriter());
				pstmt.setString(2, dto.getSubject());
				pstmt.setString(3, dto.getContent());
				pstmt.setString(4, dto.getNum());
				//실행
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		
		
		//삭제
				public void deleteSmart(String num) 
				{	
					Connection conn=null;
					PreparedStatement pstmt=null;
					
					conn=db.getConnection();
					
					String sql="delete from smartbbs where num=?";
					
					
					try {
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, num);
						//실행
						pstmt.execute();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						db.dbClose(pstmt, conn);
					}
					
				}
	
	
	/*
	 * //게시판 글 수정메소드 public void updateSmart(String num,String subject, String
	 * content) { Connection conn=null; PreparedStatement pstmt=null; String
	 * sql="update smartbbs set subject=?, content=? where num=?";
	 * conn=db.getConnection(); try { pstmt=conn.prepareStatement(sql);
	 * pstmt.setString(1, subject); pstmt.setString(2, content); pstmt.setString(3,
	 * num);
	 * 
	 * //실행 pstmt.execute(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }finally { db.dbClose(pstmt, conn); } }
	 * 
	 * 
	 * //게시판 글 삭제메소드 public void deleteSmart(String num) { Connection conn=null;
	 * PreparedStatement pstmt=null; String sql="delete from smartbbs where num=?";
	 * conn=db.getConnection(); try { pstmt=conn.prepareStatement(sql);
	 * pstmt.setString(1, num); //실행 pstmt.execute(); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }finally {
	 * db.dbClose(pstmt, conn); }
	 * 
	 * }
	 */
	
	
}
