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
	
	//아이디 있는지 없는지 확인하는 메소드
	///아이디가 존재하면 true리턴
	public boolean isIdCheck(String id)
	{
		boolean b=false;//있을 경우에만 true로 변경
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
				b=true; //b=rs.next();이렇게 짜도 된다. 있냐없냐(T/F)만 보는거라.간단.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return b;
	}
	
	//getSearchDong(String dong) : 동을 검색해서 List 로 리턴하는 메서드
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

		//insert 메소드
		public void insertMember(MemberDto dto) 
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="insert into member values (seq_mini.nextval,"
					+ "?,?,?,?,?,?,?,sysdate)";
			
			//db서버연결
			conn=db.getConnection();
			
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setString(1, dto.getMid());
				pstmt.setString(2, dto.getName());
				pstmt.setString(3, dto.getPass());
				pstmt.setString(4, dto.getHp());
				pstmt.setString(5, dto.getAddr());
				pstmt.setString(6, dto.getAddrdetail());
				pstmt.setString(7, dto.getPhoto());
				//실행
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
			
			//db연결
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
		
		//아이디에 해당하는 이름 리턴하기
		public String getName(String id)
		{
			String name="";//아이디를 보냈을때 네임이 비어있으면 아이디가 없는거
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
		
		
		//로그인시 필요
		//1:아이디, 비번 모두 맞는 경우
		//2: 비번이 틀린경우 3: 아이디가 없는 경우(false일경우)
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
				if(rs.next()) { //아이디가 있으면,
					//비번 비교
					if(rs.getString("pass").equals(pass))
						idx=1; //파라미터로 받은 pass가 같으면 =1
					else
						idx=2; //파라미터로 받은 pass가 같지않으면 =2(비번틀림)
				}else {
					idx=3; //false인 경우는 해당 아이디가 없는경우 =3
				}
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}
			
			return idx;
		}
		
	//수정폼:어차피 본인꺼만 수정/삭제가 나오므로 비번없이 수정
	//dao 에 수정,삭제에 필요한 메서드 모두 만들기
		
		//num에 해당하는 dto 데이타 반환
		
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
		
		//수정 name, hp, photo, addr addrdetail 수정(memo.dao참고)
		
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

		
		//num에 해당하는 데이타 삭제
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
		
		//아이디에 해당하는 photo 리턴하기
				public String getPhoto(String id)
				{
					String photo="";//아이디를 보냈을때 네임이 비어있으면 아이디가 없는거
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
