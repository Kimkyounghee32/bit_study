package data.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.AnswerDto;
import data.dto.BoardDto;
import oracle.db.DbConnect;

public class AnswerDao {
	DbConnect db=new DbConnect();
	
	public void insertAnswer(AnswerDto dto)
	//�Խñۿ� �޸� ���̱� ������ �ѹ��� �޾ƿ;��Ѵ�
	//sql�� ����ǥ3��
	{
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=db.getConnection();
		
		
		String sql="insert into answer values (seq_mini.nextval,?,?,?,sysdate)";	
		 try {
	         pstmt=conn.prepareStatement(sql);
	         //���ε�
	         pstmt.setString(1, dto.getMyid());
	         pstmt.setString(2, dto.getContent());
	         pstmt.setInt(3, dto.getNum());
	         //����
	         pstmt.execute();         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         db.dbClose(pstmt, conn);
	      }      
	   }
	
	
	public List<AnswerDto> getAnswerList(String num)
	
	{
		List<AnswerDto> list=new Vector<AnswerDto>();
		  Connection conn=null;
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      
	      conn=db.getConnection();
	      
	      String sql="select *from answer where num=? order by idx desc ";	
	      int n=0;
	      try {
				pstmt=conn.prepareStatement(sql);
				//���ε�
				pstmt.setString(1, num);
				//����
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					AnswerDto dto=new AnswerDto();
					dto.setIdx(rs.getString("idx"));
					dto.setMyid(rs.getString("myid"));
					dto.setContent(rs.getString("content"));
					dto.setNum(rs.getInt("num"));
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
	
	
	//idx�� �ش��ϴ� dto������ ��ȯ
	public AnswerDto getData(String idx) 
	{
		AnswerDto dto= new AnswerDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		String sql="select * from answer where idx=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				dto.setIdx(rs.getString("idx"));
				dto.setMyid(rs.getString("myid"));
				dto.setContent(rs.getString("content"));
				dto.setNum(rs.getInt("num"));
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
	
	//��� �����޼ҵ�
			public void updateAnswer(String idx, String content) 
			{
				
				 Connection conn=null;
		         PreparedStatement pstmt=null;
		         String sql="update answer set content=? where idx=?";
		         conn=db.getConnection();
		         try {
		            pstmt=conn.prepareStatement(sql);
		            pstmt.setString(1, content);
		            pstmt.setString(2, idx);
		            //����
		            pstmt.execute();
		         } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		         }finally {
		            db.dbClose(pstmt, conn);
		         }
			}
			
			
			//��� �����޼ҵ�
			public void deleteAnswer(String idx) 
			{
				Connection conn=null;
				PreparedStatement pstmt=null;
				String sql="delete from answer where idx=?";
				conn=db.getConnection();
		        try {
		           pstmt=conn.prepareStatement(sql);
		           pstmt.setString(1, idx);
		           //����
		           pstmt.execute();
		        } catch (SQLException e) {
		           // TODO Auto-generated catch block
		           e.printStackTrace();
		        }finally {
		           db.dbClose(pstmt, conn);
		        }	

			}
	
		
}
