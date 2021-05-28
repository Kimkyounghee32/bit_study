package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.MemberDto;
import data.dto.ZipcodeDto;
import oracle.db.DbConnect;

public class MemberDao {
	DbConnect db=new DbConnect();
	
	//���̵� �ִ��� ������ Ȯ���ϴ� �޼ҵ�
	///���̵� �����ϸ� true����
	public boolean isIdCheck(String id)
	{
		boolean b=false;//���� ��쿡�� true�� ����
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from member where mid=?";
		conn=db.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
				b=true; //b=rs.next();�̷��� ¥�� �ȴ�. �ֳľ���(T/F)�� ���°Ŷ�.����.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return b;
	}
	
	//getSearchDong(String dong) : ���� �˻��ؼ� List �� �����ϴ� �޼���
		public List<ZipcodeDto> getSearchDong(String dong)
		{
			List<ZipcodeDto> list=new Vector<ZipcodeDto>();
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select * from zipcode where dong like ?";
			conn=db.getConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,dong+"%");
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					ZipcodeDto dto=new ZipcodeDto();
					dto.setSido(rs.getString("sido"));
					dto.setGugun(rs.getString("gugun"));
					dto.setDong(rs.getString("dong"));
					dto.setRi(rs.getString("ri"));
					dto.setBunji(rs.getString("bunji"));
					
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

		//insert �޼ҵ�
		public void insertMember(MemberDto dto) 
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="insert into member values (seq_mini.nextval,"
					+ "?,?,?,?,?,?,?,sysdate)";
			
			//db��������
			conn=db.getConnection();
			
			try {
				pstmt=conn.prepareStatement(sql);
				//���ε�
				pstmt.setString(1, dto.getMid());
				pstmt.setString(2, dto.getName());
				pstmt.setString(3, dto.getPass());
				pstmt.setString(4, dto.getHp());
				pstmt.setString(5, dto.getAddr());
				pstmt.setString(6, dto.getAddrdetail());
				pstmt.setString(7, dto.getPhoto());
				//����
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		
		public List<MemberDto> getMemberList()
		{
			List<MemberDto> list=new Vector<MemberDto>();
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select * from member order by mid";
			
			//db����
			conn=db.getConnection();
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					MemberDto dto=new MemberDto();
					dto.setNum(rs.getString("num"));
					dto.setMid(rs.getString("mid"));
					dto.setName(rs.getString("name"));
					dto.setHp(rs.getString("hp"));
					dto.setAddr(rs.getString("addr"));
					dto.setAddrdetail(rs.getString("addrdetail"));
					dto.setPhoto(rs.getString("photo"));
					dto.setGaipday(rs.getTimestamp("gaipday"));
					
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
		
		//���̵� �ش��ϴ� �̸� �����ϱ�
		public String getName(String id)
		{
			String name="";//���̵� �������� ������ ��������� ���̵� ���°�
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select name from member where mid=?";
			conn=db.getConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				if(rs.next())
					name=rs.getString("name");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			return name;
		}
		
		
		//�α��ν� �ʿ�
		//1:���̵�, ��� ��� �´� ���
		//2: ����� Ʋ����� 3: ���̵� ���� ���(false�ϰ��)
		public int getLogin(String id, String pass)
		{
			int idx=0;
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select * from member where mid=?";
			conn=db.getConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				if(rs.next()) { //���̵� ������,
					//��� ��
					if(rs.getString("pass").equals(pass))
						idx=1; //�Ķ���ͷ� ���� pass�� ������ =1
					else
						idx=2; //�Ķ���ͷ� ���� pass�� ���������� =2(���Ʋ��)
				}else {
					idx=3; //false�� ���� �ش� ���̵� ���°�� =3
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			return idx;
		}
		
	//������:������ ���β��� ����/������ �����Ƿ� ������� ����
	//dao �� ����,������ �ʿ��� �޼��� ��� �����
		
		//num�� �ش��ϴ� dto ����Ÿ ��ȯ
		
		public MemberDto getData(String num) 
		{
			MemberDto dto=new MemberDto();
			Connection conn=null;
		    PreparedStatement pstmt=null;
		    ResultSet rs=null;
		    String sql = "select * from member where num=?";
		    
		    conn=db.getConnection();
		    try {
		    	pstmt=conn.prepareStatement(sql);
		    	pstmt.setString(1, num);
		    	rs=pstmt.executeQuery();
		    	if(rs.next())
		    	{
		    		dto.setNum(rs.getString("num"));
		    		dto.setMid(rs.getString("mid"));
		    		dto.setName(rs.getString("name"));
		    		dto.setHp(rs.getString("hp"));
		    		dto.setAddr(rs.getString("addr"));
		    		dto.setAddrdetail(rs.getString("addrdetail"));
		    		dto.setPhoto(rs.getString("photo"));
		    		dto.setGaipday(rs.getTimestamp("gaipday"));
		    	}
		    }catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }finally {
		         db.dbClose(rs, pstmt, conn);
		      }
		      return dto;
		   }
		
		//���� name, hp, photo, addr addrdetail ����(memo.dao����)
		
		public void updateMember(MemberDto dto)
		{
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "update member set name=?,hp=?,photo=?,addr=?,"
					+ "addrdetail=? where num=?";
			conn = db.getConnection();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getName());
				pstmt.setString(2, dto.getHp());
				pstmt.setString(3, dto.getPhoto());
				pstmt.setString(4, dto.getAddr());
				pstmt.setString(5, dto.getAddrdetail());
				pstmt.setString(6, dto.getNum());
				
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.dbClose(pstmt, conn);
			}
		}

		
		//num�� �ش��ϴ� ����Ÿ ����
		public void deleteMember(String num) {
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="delete from member where num=?";
			conn=db.getConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, num);
				
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
		}
		
		//���̵� �ش��ϴ� photo �����ϱ�
				public String getPhoto(String id)
				{
					String photo="";//���̵� �������� ������ ��������� ���̵� ���°�
					Connection conn=null;
					PreparedStatement pstmt=null;
					ResultSet rs=null;
					String sql="select photo from member where mid=?";
					conn=db.getConnection();
					try {
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1, id);
						rs=pstmt.executeQuery();
						if(rs.next())
							photo=rs.getString("photo");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						db.dbClose(rs, pstmt, conn);
					}
					
					return photo;
				}
			
}
