package dbguide;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test01.ClickUserVO;

public class ClickDAO {
	// 드라이버 클래스 로드
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// 커넥션 연결
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";	// 데이터베이스 서버 주소 및 연결 문자열
		String user = "javadb";	// 허가받은 사용자 아이디
		String password = "12345";	// 비밀번호
		
		Connection con = null;
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public int signUp(ClickUserVO vo) {
		int result=0;
		String sql="insert into usertbl(id, pwd) values(?, ?)";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;	
	}
	
	public ClickUserVO login(String id) {
		ClickUserVO vo=null;
		String sql="select * from usertbl where id like ?";
		
		try(Connection con=getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql)) {
			
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				vo=new ClickUserVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return vo;
	}

}
