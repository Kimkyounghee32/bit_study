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
	
	//num max=null �� ��� 0�� ����
	public int getMaxNum()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		String sql="select nvl(max(num),0) from smartbbs"; 
		//NVL �Լ��� ���� null�� ��� �������� ����Ѵ�=�߽ø� num�� ����ϴµ�, ���϶��� 0 ���
		
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
			//���ε�
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			
			//����
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//��ü ���� ���ϱ�
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
	
	//����¡ó���� �ʿ��� ����Ʈ�� ������
	public List<SmartDto> getList(int start, int end)
	{
		List<SmartDto> list=new Vector<SmartDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		 String sql = "select a.* from (select ROWNUM as RNUM,b.* from "
		            + "(select * from smartbbs order by num desc)b)a "
		            + "where a.RNUM>=? and a.RNUM<=?"; //����¡ó���Ҳ��ϱ� ����ǥ�� �״��
		 
		 		//epleSmart order by reg desc,restep asc
		 		//���ú����ε� ������ reg�� �������� restep�� ��������
		 		//�������� �̿��� ���� �� ���� �״�� ����ϸ��
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//���ε�
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			//����
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
	
	//num�� �ش��ϴ� readcount 1 ����
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
			//����
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		return n;
	}
	
	//num�� �ش��ϴ� dto������ ��ȯ
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
			//���ε�
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
	
	//����
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
				//����
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		
		
		//����
				public void deleteSmart(String num) 
				{	
					Connection conn=null;
					PreparedStatement pstmt=null;
					
					conn=db.getConnection();
					
					String sql="delete from smartbbs where num=?";
					
					
					try {
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, num);
						//����
						pstmt.execute();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						db.dbClose(pstmt, conn);
					}
					
				}
	
	
	/*
	 * //�Խ��� �� �����޼ҵ� public void updateSmart(String num,String subject, String
	 * content) { Connection conn=null; PreparedStatement pstmt=null; String
	 * sql="update smartbbs set subject=?, content=? where num=?";
	 * conn=db.getConnection(); try { pstmt=conn.prepareStatement(sql);
	 * pstmt.setString(1, subject); pstmt.setString(2, content); pstmt.setString(3,
	 * num);
	 * 
	 * //���� pstmt.execute(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); }finally { db.dbClose(pstmt, conn); } }
	 * 
	 * 
	 * //�Խ��� �� �����޼ҵ� public void deleteSmart(String num) { Connection conn=null;
	 * PreparedStatement pstmt=null; String sql="delete from smartbbs where num=?";
	 * conn=db.getConnection(); try { pstmt=conn.prepareStatement(sql);
	 * pstmt.setString(1, num); //���� pstmt.execute(); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); }finally {
	 * db.dbClose(pstmt, conn); }
	 * 
	 * }
	 */
	
	
}
