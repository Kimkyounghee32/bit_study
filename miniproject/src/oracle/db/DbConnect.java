package oracle.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
	String oracleDriver="oracle.jdbc.driver.OracleDriver";
	String oracleUrl="jdbc:oracle:thin:@localhost:1521:xe";
	String gansaUrl="jdbc:oracle:thin:@192.168.0.169:1521:xe"; //����� db����
	
	public DbConnect() {
		try {
			Class.forName(oracleDriver);       //������Ʈ �ȿ� ����Ŭ �ڷᰡ ���� ��� �ͼ��� �߻�. �Ǵ� ��Ÿ�ϰ�� �ͼ���.
			//System.out.println("����Ŭ ����̹� �˻� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����Ŭ����̹� �˻� ����:"+e.getMessage());
		}
	}
	
	//db server �����ϴ� �޼��� 
		public Connection getConnection()
		{
			Connection conn = null;
			try {
				conn=DriverManager.getConnection(oracleUrl, "angel", "a1234"); //����ŬUrl,������,��й�ȣ

				System.out.println("����Ŭ ���� ���� ����");
			} catch (SQLException e) {
				System.out.println("����Ŭ ���� ����:"+e.getMessage());
			}
			return conn;
		}
		
		//db ������ server �����ϴ� �޼��� 
		public Connection getCommonConnection()
		{
			Connection conn = null;
			try {
				conn=DriverManager.getConnection(gansaUrl, "angel", "a1234"); //����ŬUrl,������,��й�ȣ

				//System.out.println("����Ŭ ���� ���� ����");
			} catch (SQLException e) {
				System.out.println("����pc ����Ŭ ���� ����:"+e.getMessage());
			}
			return conn;
		}
			
		//db close
		public void dbClose(Statement stmt, Connection conn)//���۷��� �����̱⶧���� ���� db�� ���� ����
		{
			try{
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {}
		}
			
			public void dbClose(ResultSet rs, Statement stmt, Connection conn)
			{
				try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {}
			}
			
			
			public void dbClose(PreparedStatement pstmt, Connection conn)
			{
				try{
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {}
			}
			
			public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn)
			{
				try{
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {}
			}
			
			public void dbClose(CallableStatement cstmt, Connection conn)
			{
				try{
					if(cstmt!=null)cstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {}
			}
			
			public void dbClose(ResultSet rs, CallableStatement cstmt, Connection conn)
			{
				try{
					if(rs!=null)rs.close();
					if(cstmt!=null)cstmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {}
			}
			
		}