package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.BoardDto;
import oracle.db.DbConnect;

public class BoardDao {
	DbConnect db=new DbConnect();
	
	//num max=null �� ��� 0�� ����
	public int getMaxNum()
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		String sql="select nvl(max(num),0) from repleboard"; 
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
	
	//���� �׷��� ���޹��� step���� �� ū���� ������ ���� +1�� ����
	public void updateRestep(int reg, int restep) 
	{
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	conn=db.getConnection();
	
	String sql="update repleboard set restep=restep+1 where reg=? "
			+ "and restep>?"; 
			//reg(�׷�)�� ���ų� restep(��ۼ����� ���� ����)�� ���޹����ͺ��� Ŭ��� restep�� +1
	int n=0;
	try {
		pstmt=conn.prepareStatement(sql);
		//���ε�
		pstmt.setInt(1, reg);
		pstmt.setInt(2, restep);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		db.dbClose(pstmt, conn);
	}
	
	}
	
	//insert (����, ��� �����ؼ� insert �ϱ�)
	public void insertBoard(BoardDto dto)
	{
		//dto�� ����ִ� 4���� ���� �ϴ� ������ ����
		int num=dto.getNum();
		int reg=dto.getReg();
		int restep=dto.getRestep();
		int relevel=dto.getRelevel();
		
		if(num==0) // 0�� ��� ���۷� ����
		{	
			//�׷캯����  num�� �ִ밪 +1
			reg=this.getMaxNum()+1;
			//������ ��� 0���� �ʱ�ȭ
			restep=0;
			relevel=0;
			//���۰� ����϶��� �� ������ ����(reg,restep,relevel)�� �޶�����
			
		}
		
		else
		{ //null�� �ƴҰ�� ��۷� ����
			
			//���� �׷��� ���޹��� restep ���� ū �Խñ۵��� ��� +1
			this.updateRestep(reg, restep);
			//���� restep, relevel ��� 1����
			restep+=1;
			relevel+=1;
		}
		
		String sql="insert into repleboard values (seq_mini.nextval,"
				+ "?,?,?,?,?,?,0,sysdate)";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, dto.getMyid());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			
			//���⼭���ʹ� dto���� �����°� �ƴ϶� ������ ����
			pstmt.setInt(4, reg);
			pstmt.setInt(5, restep);
			pstmt.setInt(6, relevel);
			
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
		
		String sql="select count(*) from repleboard"; 
		
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
	public List<BoardDto> getList(int start, int end)
	{
		List<BoardDto> list=new Vector<BoardDto>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		 String sql = "select a.* from (select ROWNUM as RNUM,b.* from "
		            + "(select * from repleboard order by reg desc,restep asc)b)a "
		            + "where a.RNUM>=? and a.RNUM<=?";
		 
		 		//epleboard order by reg desc,restep asc
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
				BoardDto dto=new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setMyid(rs.getString("myid"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReg(rs.getInt("reg"));
				dto.setRestep(rs.getInt("restep"));
				dto.setRelevel(rs.getInt("relevel"));
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
		String sql="update repleboard set readcount=readcount+1 where num=?";
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
	public BoardDto getData(String num) 
	{
		BoardDto dto=new BoardDto();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=db.getConnection();
		
		String sql="select * from repleboard where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				dto.setNum(rs.getInt("num"));
				dto.setMyid(rs.getString("myid"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setReg(rs.getInt("reg"));
				dto.setRestep(rs.getInt("restep"));
				dto.setRelevel(rs.getInt("relevel"));
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
	
	//�Խ��� �� �����޼ҵ�
	public void updateBoard(String num,String subject, String content) 
	{
		 Connection conn=null;
         PreparedStatement pstmt=null;
         String sql="update repleboard set subject=?, content=? where num=?";
         conn=db.getConnection();
         try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, subject);
            pstmt.setString(2, content);
            pstmt.setString(3, num);
           
            //����
            pstmt.execute();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            db.dbClose(pstmt, conn);
         }
	}
	
	
	//�Խ��� �� �����޼ҵ�
	public void deleteBoard(String num) 
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from repleboard where num=?";
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

	}
	
	
}
