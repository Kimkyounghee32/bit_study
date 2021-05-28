package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import data.dto.GuestDto;
import oracle.db.DbConnect;

public class GuestDao {
   DbConnect db=new DbConnect();
   
   //총갯수 반환
   public int getTotalCount()
   {
      int total=0;
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      String sql="select count(*) from guest";
      
      conn=db.getConnection();
      try {
         pstmt=conn.prepareStatement(sql);
         rs=pstmt.executeQuery();
         if(rs.next())
            total=rs.getInt(1);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         db.dbClose(rs, pstmt, conn);
      }
      return total;
   }
   //start 부터 4씩 반환
   public List<GuestDto> getList(int start)
   {
      List<GuestDto> list=new Vector<GuestDto>();
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      String sql = "select a.* from (select ROWNUM as RNUM,b.* from "
            + "(select * from guest order by num desc)b)a "
            + "where a.RNUM>=? and a.RNUM<=?";
      
      conn=db.getConnection();
      try {
         pstmt=conn.prepareStatement(sql);         
         //바인딩
         pstmt.setInt(1, start);
         pstmt.setInt(2, start+3);
         //실행
         rs=pstmt.executeQuery();
         while(rs.next())
         {
            GuestDto dto=new GuestDto();
            dto.setNum(rs.getString("num"));
            dto.setWriter(rs.getString("writer"));
            dto.setContent(rs.getString("content"));
            dto.setPhoto(rs.getString("photo"));
            dto.setLikes(rs.getInt("likes"));
            dto.setWriteday(rs.getTimestamp("writeday"));
            //목록에 추가
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
   
   //insert
   public void insertGuest(GuestDto dto)
   {
      Connection conn=null;
      PreparedStatement pstmt=null;
      String sql="insert into guest (num,writer,content,photo,writeday)"
            + " values (seq_mini.nextval,?,?,?,sysdate)";
      conn=db.getConnection();
      try {
         pstmt=conn.prepareStatement(sql);
         //바인딩
         pstmt.setString(1, dto.getWriter());
         pstmt.setString(2, dto.getContent());
         pstmt.setString(3, dto.getPhoto());
         //실행
         pstmt.execute();         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         db.dbClose(pstmt, conn);
      }      
   }
   
   public GuestDto getData(String num)
   {
      GuestDto dto=new GuestDto();
      Connection conn=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      String sql = "select * from guest where num=?";
      
      conn=db.getConnection();
      try {
         pstmt=conn.prepareStatement(sql);         
         //바인딩
         pstmt.setString(1, num);
         //실행
         rs=pstmt.executeQuery();
         if(rs.next())
         {
            
            dto.setNum(rs.getString("num"));
            dto.setWriter(rs.getString("writer"));
            dto.setContent(rs.getString("content"));
            dto.setPhoto(rs.getString("photo"));
            dto.setLikes(rs.getInt("likes"));
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

   //좋아요값 수정
      public void updateLikes(String num)
      {
         Connection conn=null;
         PreparedStatement pstmt=null;
         int likes=this.getData(num).getLikes();
         String sql="update guest set likes=? where num=?";
         conn=db.getConnection();
         try {
            pstmt=conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1,likes==0?1:0);
            pstmt.setString(2,num);
            //실행
            pstmt.execute();         
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            db.dbClose(pstmt, conn);
         }      
      }

      public void updateGuest(String num,String content)
      {
         Connection conn=null;
         PreparedStatement pstmt=null;
         String sql="update guest set content=? where num=?";
         conn=db.getConnection();
         try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, content);
            pstmt.setString(2, num);
            pstmt.execute();
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }finally {
            db.dbClose(pstmt, conn);
         }
      }
      public void deleteGuest(String num)
      {
         Connection conn=null;
         PreparedStatement pstmt=null;
         String sql="delete from guest where num=?";
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
      
}